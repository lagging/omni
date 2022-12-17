package com.creditsaison.omni.service;

import com.creditsaison.omni.document.FoodFacilityPermit;
import com.creditsaison.omni.pojos.FoodFacilityPermitPojo;
import com.creditsaison.omni.pojos.NearestFacilityTypeRequest;
import com.creditsaison.omni.pojos.response.FoodFacilitySearchResponse;
import com.creditsaison.omni.util.exception.CSException;

public interface FoodFacilityService {

    FoodFacilityPermit addNewFoodFacilityPermit(FoodFacilityPermitPojo foodFacilityPermitPojo);

    FoodFacilitySearchResponse search(String applicantName,
                                      String streetName,
                                      String expirationDate,
                                      int pageNumber,
                                      int pageSize) throws CSException;

    FoodFacilityPermit searchNearestFacilityType(NearestFacilityTypeRequest nearestFacilityTypeRequest);
}
