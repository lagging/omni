package com.creditsaison.omni.service.impl;

import com.creditsaison.omni.document.FoodFacilityPermit;
import com.creditsaison.omni.pojos.FoodFacilityPermitPojo;
import com.creditsaison.omni.repository.FoodFacilityPermitRepository;
import com.creditsaison.omni.service.FoodFacilityService;
import com.creditsaison.omni.transformers.FoodFacilityPermitTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
