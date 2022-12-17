package com.creditsaison.omni.controllers;

import com.creditsaison.omni.pojos.FoodFacilityPermitPojo;
import com.creditsaison.omni.service.FoodFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/food-facility")
public class FoodFacilityPermitController extends BaseController{

    @Autowired
    private FoodFacilityService foodFacilityService;

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewFoodFacilityPermit(@Valid @RequestBody FoodFacilityPermitPojo foodFacilityPermitPojo){
        return this.executeTask(() -> foodFacilityService.addNewFoodFacilityPermit(foodFacilityPermitPojo));
    }
}
