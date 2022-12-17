package com.creditsaison.omni.service.impl;

import com.creditsaison.omni.document.FoodFacilityPermit;
import com.creditsaison.omni.pojos.FoodFacilityPermitPojo;
import com.creditsaison.omni.pojos.Location;
import com.creditsaison.omni.repository.FoodFacilityPermitRepository;
import com.creditsaison.omni.service.CSVService;
import com.creditsaison.omni.transformers.FoodFacilityPermitTransformer;
import com.creditsaison.omni.util.date.DateTimeUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CSVServiceImpl implements CSVService {

    @Autowired
    private FoodFacilityPermitRepository foodFacilityPermitRepository;

    @Autowired
    private FoodFacilityPermitTransformer foodFacilityPermitTransformer;

    @Override
    public boolean save(MultipartFile file) throws IOException {
        List<FoodFacilityPermitPojo> foodFacilityPermitPojos = csvToFoodFacilityPermits(file.getInputStream());
        List<FoodFacilityPermit> foodFacilityPermitList = new ArrayList<>();
        for (FoodFacilityPermitPojo foodFacilityPermitPojo : foodFacilityPermitPojos) {
            FoodFacilityPermit foodFacilityPermit = foodFacilityPermitTransformer.apply(foodFacilityPermitPojo);
            foodFacilityPermitList.add(foodFacilityPermit);
        }
        foodFacilityPermitRepository.saveAll(foodFacilityPermitList);
        return true;
    }

    public static List<FoodFacilityPermitPojo> csvToFoodFacilityPermits(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<FoodFacilityPermitPojo> foodFacilityPermits = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                FoodFacilityPermitPojo foodFacilityPermit = new FoodFacilityPermitPojo();
                if (StringUtils.isNotEmpty(csvRecord.get("locationid"))) {
                    foodFacilityPermit.setLocationId(Integer.valueOf(csvRecord.get("locationid")));
                }
                foodFacilityPermit.setApplicant(csvRecord.get("Applicant"));
                foodFacilityPermit.setFacilityType(csvRecord.get("FacilityType"));
                if (StringUtils.isNotEmpty(csvRecord.get("cnn"))) {
                    foodFacilityPermit.setCnn(Integer.valueOf(csvRecord.get("cnn")));
                }
                foodFacilityPermit.setLocationDescription(csvRecord.get("LocationDescription"));
                foodFacilityPermit.setAddress(csvRecord.get("Address"));
                foodFacilityPermit.setBlockLot(csvRecord.get("blocklot"));
                foodFacilityPermit.setBlockNumber(csvRecord.get("block"));
                foodFacilityPermit.setLot(csvRecord.get("lot"));
                foodFacilityPermit.setPermitNumber(csvRecord.get("permit"));
                foodFacilityPermit.setStatus(csvRecord.get("Status"));
                foodFacilityPermit.setFoodItems(csvRecord.get("FoodItems"));
                foodFacilityPermit.setX(csvRecord.get("X"));
                foodFacilityPermit.setY(csvRecord.get("Y"));
                if (StringUtils.isNotEmpty(csvRecord.get("Latitude"))) {
                    foodFacilityPermit.setLatitude(Double.valueOf(csvRecord.get("Latitude")));
                }
                if (StringUtils.isNotEmpty(csvRecord.get("Longitude"))) {
                    foodFacilityPermit.setLongitude(Double.valueOf(csvRecord.get("Longitude")));
                }
                foodFacilityPermit.setSchedule(csvRecord.get("Schedule"));
                foodFacilityPermit.setDaysHours(csvRecord.get("dayshours"));
                if (StringUtils.isNotEmpty(csvRecord.get("NOISent"))) {
                    foodFacilityPermit.setNoiSent(DateTimeUtil.getDateFromString(csvRecord.get("NOISent"), "MM/dd/yyyy hh:mm:ss a"));
                }
                if (StringUtils.isNotEmpty(csvRecord.get("Approved"))) {
                    foodFacilityPermit.setApprovedOn(csvRecord.get("Approved"));
                }
                foodFacilityPermit.setReceived(csvRecord.get("Received"));
                if (StringUtils.isNotEmpty(csvRecord.get("PriorPermit"))) {
                    foodFacilityPermit.setPriorPermitNumber(Integer.valueOf(csvRecord.get("PriorPermit")));
                }
                if (StringUtils.isNotEmpty(csvRecord.get("ExpirationDate"))) {
                    foodFacilityPermit.setExpirationDate(csvRecord.get("ExpirationDate"));
                }
                if (StringUtils.isNotEmpty(csvRecord.get("Location"))) {
                    String location = csvRecord.get("Location");
                    String strNew = location.replace("(", "");
                    String strNew2 = strNew.replace(")", "");
                    List<String> latLongList = Arrays.asList(strNew2.split(","));
                    foodFacilityPermit.setLocation(Location.builder()
                            .latitude(Double.valueOf(latLongList.get(0)))
                            .longitude(Double.valueOf(latLongList.get(1)))
                            .build());
                }
                if (StringUtils.isNotEmpty(csvRecord.get("Fire Prevention Districts"))) {
                    foodFacilityPermit.setFirePreventionDistricts(Integer.valueOf(csvRecord.get("Fire Prevention Districts")));
                }
                if (StringUtils.isNotEmpty(csvRecord.get("Police Districts"))) {
                    foodFacilityPermit.setPoliceDistricts(Integer.valueOf(csvRecord.get("Police Districts")));
                }
                if (StringUtils.isNotEmpty(csvRecord.get("Supervisor Districts"))) {
                    foodFacilityPermit.setSupervisionDistricts(Integer.valueOf(csvRecord.get("Supervisor Districts")));
                }
                if (StringUtils.isNotEmpty(csvRecord.get("Zip Codes"))) {
                    foodFacilityPermit.setZipCodes(Integer.valueOf(csvRecord.get("Zip Codes")));
                }
                if (StringUtils.isNotEmpty(csvRecord.get("Neighborhoods (old)"))) {
                    foodFacilityPermit.setNeighbourHoodOld(Integer.valueOf(csvRecord.get("Neighborhoods (old)")));
                }
                foodFacilityPermits.add(foodFacilityPermit);
            }
            return foodFacilityPermits;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
