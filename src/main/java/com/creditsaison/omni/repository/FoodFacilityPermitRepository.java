package com.creditsaison.omni.repository;

import com.creditsaison.omni.document.FoodFacilityPermit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FoodFacilityPermitRepository extends MongoRepository<FoodFacilityPermit, String> {

    List<FoodFacilityPermit> findFoodFacilityPermitByApplicantOrderByIdDesc(String applicant, Pageable pageable);

    List<FoodFacilityPermit> findFoodFacilityPermitByAddressOrderByIdDesc(String address, Pageable pageable);

    List<FoodFacilityPermit> findFoodFacilityPermitsByExpirationDateBefore(Long time, Pageable pageable);

    List<FoodFacilityPermit> findFoodFacilityPermitsByApplicantAndAddressOrderByIdDesc(String applicant, String address, Pageable pageable);

    List<FoodFacilityPermit> findFoodFacilityPermitsByApplicantAndExpirationDateBeforeOrderByIdDesc(String applicant, Long time, Pageable pageable);

    List<FoodFacilityPermit> findFoodFacilityPermitsByAddressAndExpirationDateBeforeOrderByIdDesc(String address, Long time, Pageable pageable);

    List<FoodFacilityPermit> findFoodFacilityPermitsByApplicantAndAddressAndExpirationDateBefore(String applicant, String address, Long time, Pageable pageable);

}
