package com.creditsaison.omni.transformers;

import com.creditsaison.omni.document.FoodFacilityPermit;
import com.creditsaison.omni.pojos.FoodFacilityPermitPojo;
import com.creditsaison.omni.util.exception.LocationUtils;
import com.creditsaison.omni.util.date.DateTimeUtil;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FoodFacilityPermitTransformer implements Function<FoodFacilityPermitPojo, FoodFacilityPermit> {

    @Override
    public FoodFacilityPermit apply(FoodFacilityPermitPojo foodFacilityPermitPojo) {
        FoodFacilityPermit foodFacilityPermit = new FoodFacilityPermit();
        if (foodFacilityPermitPojo == null){
            return foodFacilityPermit;
        }
        foodFacilityPermit.setId(foodFacilityPermitPojo.getId());
        foodFacilityPermit.setLocationId(foodFacilityPermitPojo.getLocationId());
        foodFacilityPermit.setApplicant(foodFacilityPermitPojo.getApplicant());
        foodFacilityPermit.setFacilityType(foodFacilityPermitPojo.getFacilityType());
        foodFacilityPermit.setCnn(foodFacilityPermitPojo.getCnn());
        foodFacilityPermit.setLocationDescription(foodFacilityPermitPojo.getLocationDescription());
        foodFacilityPermit.setAddress(foodFacilityPermitPojo.getAddress());
        foodFacilityPermit.setBlockLot(foodFacilityPermitPojo.getBlockLot());
        foodFacilityPermit.setBlockNumber(foodFacilityPermitPojo.getBlockNumber());
        foodFacilityPermit.setLot(foodFacilityPermitPojo.getLot());
        foodFacilityPermit.setPermitNumber(foodFacilityPermitPojo.getPermitNumber());
        foodFacilityPermit.setStatus(foodFacilityPermitPojo.getStatus());
        foodFacilityPermit.setFoodItems(foodFacilityPermitPojo.getFoodItems());
        foodFacilityPermit.setX(foodFacilityPermitPojo.getX());
        foodFacilityPermit.setY(foodFacilityPermitPojo.getY());
        foodFacilityPermit.setLatitude(foodFacilityPermitPojo.getLatitude());
        foodFacilityPermit.setLongitude(foodFacilityPermitPojo.getLongitude());
        foodFacilityPermit.setSchedule(foodFacilityPermitPojo.getSchedule());
        foodFacilityPermit.setDaysHours(foodFacilityPermitPojo.getDaysHours());
        foodFacilityPermit.setNoiSent(foodFacilityPermitPojo.getNoiSent());
        foodFacilityPermit.setApprovedOn(DateTimeUtil.getEpochDateFromString(foodFacilityPermitPojo.getApprovedOn(), "MM/dd/yyyy hh:mm:ss a"));
        foodFacilityPermit.setReceived(foodFacilityPermitPojo.getReceived());
        foodFacilityPermit.setPriorPermitNumber(foodFacilityPermitPojo.getPriorPermitNumber());
        foodFacilityPermit.setExpirationDate(DateTimeUtil.getEpochDateFromString(foodFacilityPermitPojo.getExpirationDate(),"MM/dd/yyyy hh:mm:ss a"));
        foodFacilityPermit.setLocation(LocationUtils.getGeoJsonPoint(foodFacilityPermitPojo.getLocation()));
        foodFacilityPermit.setFirePreventionDistricts(foodFacilityPermitPojo.getFirePreventionDistricts());
        foodFacilityPermit.setPoliceDistricts(foodFacilityPermitPojo.getPoliceDistricts());
        foodFacilityPermit.setSupervisionDistricts(foodFacilityPermitPojo.getSupervisionDistricts());
        foodFacilityPermit.setZipCodes(foodFacilityPermitPojo.getZipCodes());
        foodFacilityPermit.setNeighbourHoodOld(foodFacilityPermitPojo.getNeighbourHoodOld());
        return foodFacilityPermit;
    }





}
