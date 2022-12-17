package com.creditsaison.omni.pojos;

import com.creditsaison.omni.enums.FacilityType;
import com.creditsaison.omni.enums.Status;
import com.creditsaison.omni.validators.ValidFacilityType;
import com.creditsaison.omni.validators.ValidLocation;
import com.creditsaison.omni.validators.ValidStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodFacilityPermitPojo {

    @NotNull
    private Integer locationId;

    @NotNull
    @NotEmpty
    private String applicant;

    @ValidFacilityType()
    private String facilityType;

    @NotNull
    private Integer cnn;

    private String locationDescription;

    @NotNull
    @NotEmpty
    private String address;

    @NotNull
    @NotEmpty
    private String blockLot;

    @NotNull
    @NotEmpty
    private String blockNumber;

    @NotNull
    @NotEmpty
    private String lot;

    @NotNull
    @NotEmpty
    private String permitNumber;

    @ValidStatus()
    private String status;

    private String foodItems;

    @NotNull
    @NotEmpty
    private String x;

    @NotNull
    @NotEmpty
    private String y;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    @NotEmpty
    private String schedule;

    private String daysHours;

    private Date noiSent;

    private String approvedOn;

    @NotNull
    @NotEmpty
    private String received;

    @NotNull
    private Integer priorPermitNumber;


    @NotNull
    @NotEmpty
    private String expirationDate;

    @ValidLocation()
    private Location location;

    private Integer firePreventionDistricts;

    private Integer policeDistricts;

    private Integer supervisionDistricts;

    private Integer zipCodes;

    private Integer neighbourHoodOld;

}
