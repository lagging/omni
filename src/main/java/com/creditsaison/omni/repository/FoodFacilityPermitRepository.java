package com.creditsaison.omni.repository;

import com.creditsaison.omni.document.FoodFacilityPermit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodFacilityPermitRepository extends MongoRepository<FoodFacilityPermit, Integer> {
}
