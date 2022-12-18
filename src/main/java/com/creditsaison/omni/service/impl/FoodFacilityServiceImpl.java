package com.creditsaison.omni.service.impl;

import com.creditsaison.omni.document.FoodFacilityPermit;
import com.creditsaison.omni.enums.FoodFacilitySearchType;
import com.creditsaison.omni.pojos.FoodFacilityPermitPojo;
import com.creditsaison.omni.pojos.NearestFacilityTypeRequest;
import com.creditsaison.omni.pojos.response.FoodFacilitySearchResponse;
import com.creditsaison.omni.repository.FoodFacilityPermitRepository;
import com.creditsaison.omni.service.FoodFacilityService;
import com.creditsaison.omni.transformers.FoodFacilityPermitTransformer;
import com.creditsaison.omni.util.date.DateTimeUtil;
import com.creditsaison.omni.util.exception.CSException;
import com.creditsaison.omni.util.exception.ErrorCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodFacilityServiceImpl implements FoodFacilityService {

    @Autowired
    private FoodFacilityPermitRepository foodFacilityPermitRepository;

    @Autowired
    private FoodFacilityPermitTransformer foodFacilityPermitTransformer;

    @Override
    public FoodFacilityPermit addNewFoodFacilityPermit(FoodFacilityPermitPojo foodFacilityPermitPojo) {
        FoodFacilityPermit foodFacilityPermit = foodFacilityPermitTransformer.apply(foodFacilityPermitPojo);
        return foodFacilityPermitRepository.save(foodFacilityPermit);
    }

    @Override
    public FoodFacilitySearchResponse search(String applicantName,
                                             String streetName,
                                             String expirationDate,
                                             int pageNumber,
                                             int pageSize) throws CSException {
        if (StringUtils.isEmpty(applicantName) && StringUtils.isEmpty(streetName) && StringUtils.isEmpty(expirationDate)) {
            throw new CSException(ErrorCode.BAD_REQUEST_ERROR, "One of the following parameters should be present Applicant name, street name, expiration date");
        }
        List<FoodFacilityPermit> foodFacilityPermitList = new ArrayList<>();
        boolean isApplicantNamePresent = StringUtils.isNotEmpty(applicantName);
        boolean isStreetNamePresent = StringUtils.isNotEmpty(streetName);
        boolean isExpiryDatePresent = StringUtils.isNotEmpty(expirationDate);
        Long expirationDateInEpoch = null;
        if (isExpiryDatePresent) {
            boolean isValidDate = DateTimeUtil.isValidDate(expirationDate);
            if (!isValidDate) {
                throw new CSException(ErrorCode.BAD_REQUEST_ERROR, "Provide expiration date in this format 'MM/dd/yyyy hh:mm:ss a'");
            }
            expirationDateInEpoch = DateTimeUtil.getEpochDateFromString(expirationDate, "MM/dd/yyyy hh:mm:ss a");
        }
        FoodFacilitySearchType foodFacilitySearchType = FoodFacilitySearchType.getFoodFacilitySearchType(isApplicantNamePresent, isStreetNamePresent, isExpiryDatePresent);
        switch (foodFacilitySearchType){
            case APPLICANT_STREET_EXPIRY_DATE:
                foodFacilityPermitList = foodFacilityPermitRepository.findFoodFacilityPermitsByApplicantAndAddressAndExpirationDateBefore(applicantName,
                        streetName,
                        expirationDateInEpoch,
                        PageRequest.of(pageNumber, pageSize));
                break;
            case APPLICANT_STREET:
                foodFacilityPermitList = foodFacilityPermitRepository.findFoodFacilityPermitsByApplicantAndAddressOrderByIdDesc(applicantName,
                        streetName,
                        PageRequest.of(pageNumber, pageSize));
                break;
            case APPLICANT_EXPIRY_DATE:
                foodFacilityPermitList = foodFacilityPermitRepository.findFoodFacilityPermitsByApplicantAndExpirationDateBeforeOrderByIdDesc(applicantName,
                        expirationDateInEpoch,
                        PageRequest.of(pageNumber, pageSize));
                break;
            case STREET_EXPIRY_DATE:
                foodFacilityPermitList = foodFacilityPermitRepository.findFoodFacilityPermitsByAddressAndExpirationDateBeforeOrderByIdDesc(streetName,
                        expirationDateInEpoch,
                        PageRequest.of(pageNumber, pageSize));
                break;
            case APPLICANT:
                foodFacilityPermitList = foodFacilityPermitRepository.findFoodFacilityPermitByApplicantOrderByIdDesc(applicantName,
                        PageRequest.of(pageNumber, pageSize));
                break;
            case STREET:
                foodFacilityPermitList = foodFacilityPermitRepository.findFoodFacilityPermitByAddressOrderByIdDesc(streetName,
                        PageRequest.of(pageNumber, pageSize));
                break;
            case EXPIRY_DATE:
                foodFacilityPermitList = foodFacilityPermitRepository.findFoodFacilityPermitsByExpirationDateBefore(expirationDateInEpoch,
                        PageRequest.of(pageNumber, pageSize));
                break;

        }
        return FoodFacilitySearchResponse.builder()
                .foodFacilityPermitList(foodFacilityPermitList)
                .build();
    }


    @Override
    public FoodFacilityPermit searchNearestFacilityType(NearestFacilityTypeRequest nearestFacilityTypeRequest) {
        FoodFacilityPermit nearestFoodFacilityPermit = null;
        String facilityType = nearestFacilityTypeRequest.getFacilityType();
        double latitude = Double.parseDouble(nearestFacilityTypeRequest.getLatitude());
        double longitude = Double.parseDouble(nearestFacilityTypeRequest.getLongitude());
        List<FoodFacilityPermit> foodFacilityPermitList = foodFacilityPermitRepository.findByFacilityTypeAndLocationNear(facilityType, new Point(longitude, latitude));
        if (CollectionUtils.isEmpty(foodFacilityPermitList)){
            return nearestFoodFacilityPermit;
        }
        return foodFacilityPermitList.get(0);
    }


}
