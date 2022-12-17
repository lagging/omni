package com.creditsaison.omni.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class FoodFacilityPermit {

    @Id
    private Integer id;

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

    private Date approvedOn;

    private String received;

    private Integer priorPermitNumber;

    private Date expirationDate;

    private GeoJsonPoint location;

}
