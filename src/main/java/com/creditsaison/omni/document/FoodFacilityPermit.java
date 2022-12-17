package com.creditsaison.omni.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document
@CompoundIndexes(
        {
                @CompoundIndex(name = "applicant_1_address_1_expirationDate_1", def = "{'applicant' : 1, 'address': 1, 'expirationDate': 1}"),
                @CompoundIndex(name = "applicant_1_expirationDate_1", def = "{'applicant' : 1, 'expirationDate': 1}"),
                @CompoundIndex(name = "address_1_expirationDate_1", def = "{'address': 1, 'expirationDate': 1}"),
                @CompoundIndex(name = "expirationDate_1", def = "{'expirationDate': 1}"),
        }
)
public class FoodFacilityPermit {

    @Id
    private String id;

    private Integer locationId;

    private String applicant;

    private String facilityType;

    private Integer cnn;

    private String locationDescription;

    private String address;

    private String blockLot;

    private String blockNumber;

    private String lot;

    private String permitNumber;

    private String status;

    private String foodItems;

    private String x;

    private String y;

    private Double latitude;

    private Double longitude;

    private String schedule;

    private String daysHours;

    private Date noiSent;

    private Long approvedOn;

    private String received;

    private Integer priorPermitNumber;

    private Long expirationDate;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

    private Integer firePreventionDistricts;

    private Integer policeDistricts;

    private Integer supervisionDistricts;

    private Integer zipCodes;

    private Integer neighbourHoodOld;

}
