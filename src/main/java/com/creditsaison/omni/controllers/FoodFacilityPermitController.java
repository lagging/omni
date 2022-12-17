package com.creditsaison.omni.controllers;

import com.creditsaison.omni.pojos.FoodFacilityPermitPojo;
import com.creditsaison.omni.pojos.NearestFacilityTypeRequest;
import com.creditsaison.omni.service.FoodFacilityService;
import com.creditsaison.omni.util.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/food-facility")
public class FoodFacilityPermitController extends BaseController {

    @Autowired
    private FoodFacilityService foodFacilityService;

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewFoodFacilityPermit(@Valid @RequestBody FoodFacilityPermitPojo foodFacilityPermitPojo) {
        return this.executeTask(() -> foodFacilityService.addNewFoodFacilityPermit(foodFacilityPermitPojo));
    }

    @GetMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> search(@RequestParam(value = "applicant", required = false) String applicantName,
                                    @RequestParam(value = "streetName", required = false) String streetName,
                                    @RequestParam(value = "expirationDate", required = false) String expirationDate,
                                    @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "100") int pageSize) {
        return this.executeTask(() -> foodFacilityService.search(applicantName, streetName, expirationDate, pageNumber, pageSize));
    }

    @GetMapping(path = "/facility", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchNearestFacilityType(@Valid @ModelAttribute NearestFacilityTypeRequest nearestFacilityTypeRequest) throws BadRequestException {
        return this.executeTask(() -> foodFacilityService.searchNearestFacilityType(nearestFacilityTypeRequest));
    }


}
