package com.creditsaison.omni.pojos;

import com.creditsaison.omni.validators.ValidFacilityType;
import com.creditsaison.omni.validators.ValidLatitude;
import com.creditsaison.omni.validators.ValidLongitude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NearestFacilityTypeRequest {

    @ValidFacilityType
    private String facilityType;

    @ValidLatitude
    private String latitude;

    @ValidLongitude
    private String longitude;
}
