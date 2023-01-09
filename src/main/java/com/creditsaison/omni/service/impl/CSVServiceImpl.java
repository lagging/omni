package com.creditsaison.omni.service.impl;

import com.creditsaison.omni.document.FoodFacilityPermit;
import com.creditsaison.omni.pojos.*;
import com.creditsaison.omni.repository.FoodFacilityPermitRepository;
import com.creditsaison.omni.service.CSVService;
import com.creditsaison.omni.transformers.FoodFacilityPermitTransformer;
import com.creditsaison.omni.util.date.DateTimeUtil;
import com.opencsv.CSVWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public BatchesNPSInfo parseCSV(MultipartFile file) throws IOException {
        BatchesNPSInfo batchesNPSInfoP = csvToBatchesNPS(file.getInputStream(), "P");
        writeToFile(batchesNPSInfoP,"Nps-P.csv");
        BatchesNPSInfo batchesNPSInfoD = csvToBatchesNPS(file.getInputStream(), "D");
        writeToFile(batchesNPSInfoD,"Nps-D.csv");
        BatchesNPSInfo batchesNPSInfoN = csvToBatchesNPS(file.getInputStream(), "N");
        writeToFile(batchesNPSInfoN,"Nps-N.csv");
        return batchesNPSInfoP;
    }

    private void writeToFile(BatchesNPSInfo batchesNPSInfo, String fileName){
        File file = new File("/Users/mr/Downloads/"+fileName);
        List<BatchInfo> batchInfoList = batchesNPSInfo.getBatchInfoList();
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);
            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);
            for (BatchInfo batchInfo: batchInfoList){
                String batchName = batchInfo.getBatchName();
                List<MainTagInfo> mainTagInfoList = batchInfo.getMainTagInfoList();
                for (MainTagInfo mainTagInfo: mainTagInfoList){
                    String mainTagName = mainTagInfo.getMainTagName();
                    Map<String, Integer> subTagNameCountMap = mainTagInfo.getSubTagNameCountMap();
                    for (Map.Entry<String,Integer> entry: subTagNameCountMap.entrySet()){
                        String[] row = new String[4];
                        String subTagName = entry.getKey();
                        String count = String.valueOf(entry.getValue());
                        row[0]=batchName;
                        row[1]=mainTagName;
                        row[2]=subTagName;
                        row[3]=count;
                        writer.writeNext(row);
                    }
                }
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BatchesNPSInfo csvToBatchesNPS(InputStream is, String type) throws IOException {
        Set<String> batches = new HashSet<>();
        List<BatchInfo> batchInfoList = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
             ) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                if (type.equals(csvRecord.get("P/N/D"))){
                    String batchName = csvRecord.get("super_batch_name");
                    batches.add(batchName);
                }
            }
            for (String batch : batches) {
                csvRecords = getCSVParser();
                Map<String, Integer> subTagCount = new HashMap<>();
                for (CSVRecord csvRecord : csvRecords) {
                    if (csvRecord.get("super_batch_name").equals(batch) && csvRecord.get("P/N/D").equals(type)) {
                        String mainTagsStr = csvRecord.get("issues");
                        List<String> mainTags = Arrays.asList(mainTagsStr.split(","));
                        mainTags = mainTags.stream().map(String::trim).collect(Collectors.toList());
                        for (String mainTag : mainTags) {
                            String subTagsStr = "";
                            if ("TEACHING ASSISTANCE".equalsIgnoreCase(mainTag)) {
                                subTagsStr = csvRecord.get("ta_issues");
                            } else if ("CUSTOMER SUPPORT".equalsIgnoreCase(mainTag)) {
                                subTagsStr = csvRecord.get("support_issues");
                            } else if ("MENTORSHIP".equalsIgnoreCase(mainTag)) {
                                subTagsStr = csvRecord.get("mentorship_issues");
                            } else if ("INSTRUCTOR".equalsIgnoreCase(mainTag)) {
                                subTagsStr = csvRecord.get("instructor_issues");
                            } else if ("DASHBOARD".equalsIgnoreCase(mainTag)) {
                                subTagsStr = csvRecord.get("dashboard_issues");
                            } else if ("COMMUNITY".equalsIgnoreCase(mainTag)) {
                                subTagsStr = csvRecord.get("community_issues");
                            } else if ("CLASSROOM".equalsIgnoreCase(mainTag)) {
                                subTagsStr = csvRecord.get("classroom_issues");
                            }
                            List<String> subTags = Arrays.asList(subTagsStr.split(","));
                            subTags = subTags.stream().map(String::trim).collect(Collectors.toList());
                            for (String subTag : subTags) {
                                if (StringUtils.isEmpty(subTag)){
                                    continue;
                                }
                                int existingCount = subTagCount.getOrDefault(subTag, 0);
                                subTagCount.put(subTag, existingCount + 1);
                            }
                        }
                    }
                }
                Map<String, Map<String, Integer>> tagSubTagNameCount = getTagNameSubTagNameWithCount(subTagCount);
                List<MainTagInfo> mainTagInfoList = new ArrayList<>();
                for (Map.Entry<String, Map<String, Integer>> stringMapEntry : tagSubTagNameCount.entrySet()) {
                    mainTagInfoList.add(MainTagInfo.builder()
                            .mainTagName(stringMapEntry.getKey())
                            .subTagNameCountMap(stringMapEntry.getValue())
                            .build());
                }
                BatchInfo batchInfo = BatchInfo.builder()
                        .batchName(batch)
                        .mainTagInfoList(mainTagInfoList)
                        .build();
                batchInfoList.add(batchInfo);
            }
            return BatchesNPSInfo.builder()
                    .batchInfoList(batchInfoList)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    private Iterable<CSVRecord> getCSVParser(){
        try (
                Reader reader = Files.newBufferedReader(Paths.get("/Users/mr/Downloads/WorkingSheet.csv"));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        ) {
            return csvParser.getRecords();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, Map<String, Integer>> getTagNameSubTagNameWithCount(Map<String, Integer> subTagCount) {
        Map<String, String> subtagTagName = new HashMap<>();
        subtagTagName.put("Guidance", "TEACHING ASSISTANCE");
        subtagTagName.put("Approach and Explanation", "TEACHING ASSISTANCE");
        subtagTagName.put("Testing", "TEACHING ASSISTANCE");
        subtagTagName.put("Explanation", "TEACHING ASSISTANCE");
        subtagTagName.put("Availability", "TEACHING ASSISTANCE");
        subtagTagName.put("Solution/Code", "TEACHING ASSISTANCE");
        subtagTagName.put("Response", "CUSTOMER SUPPORT");
        subtagTagName.put("Support accessiblity", "CUSTOMER SUPPORT");
        subtagTagName.put("Approachable", "CUSTOMER SUPPORT");
        subtagTagName.put("Resolution", "CUSTOMER SUPPORT");
        subtagTagName.put("Cancellation/Rescheduling", "MENTORSHIP");
        subtagTagName.put("Detailed Feedback", "MENTORSHIP");
        subtagTagName.put("Connect & Rapport", "MENTORSHIP");
        subtagTagName.put("Availability", "MENTORSHIP");
        subtagTagName.put("Support", "MENTORSHIP");
        subtagTagName.put("Techniques", "MENTORSHIP");
        subtagTagName.put("Intuition Building", "INSTRUCTOR");
        subtagTagName.put("Explanations", "INSTRUCTOR");
        subtagTagName.put("Teaching skills", "INSTRUCTOR");
        subtagTagName.put("Methodology & Approach", "INSTRUCTOR");
        subtagTagName.put("Lecture pace", "INSTRUCTOR");
        subtagTagName.put("Doubt Handling", "INSTRUCTOR");
        subtagTagName.put("Example Problems", "INSTRUCTOR");
        subtagTagName.put("Navigation", "DASHBOARD");
        subtagTagName.put("Streak and goals", "DASHBOARD");
        subtagTagName.put("Coding platform", "DASHBOARD");
        subtagTagName.put("Leaderboard", "DASHBOARD");
        subtagTagName.put("UI/UX", "DASHBOARD");
        subtagTagName.put("Engagement", "COMMUNITY");
        subtagTagName.put("Interaction with Community", "COMMUNITY");
        subtagTagName.put("Networking", "COMMUNITY");
        subtagTagName.put("Masterclass/Ask Me Anything Sessions", "COMMUNITY");
        subtagTagName.put("1:1 Interactions", "COMMUNITY");
        subtagTagName.put("Initiative", "COMMUNITY");
        subtagTagName.put("Curriculum & Content", "CLASSROOM");
        subtagTagName.put("Assignments & Problem solving", "CLASSROOM");
        subtagTagName.put("Teaching Methodology", "CLASSROOM");
        subtagTagName.put("Interaction/Quiz", "CLASSROOM");
        subtagTagName.put("Lecture Duration", "CLASSROOM");
        subtagTagName.put("Program Pace & Structure", "CLASSROOM");
        subtagTagName.put("Cancellation/Rescheduling", "CLASSROOM");
        Map<String, Map<String, Integer>> tagSubTagNameCount = new HashMap<>();
        for (Map.Entry<String, Integer> entry : subTagCount.entrySet()) {
            String subTag = entry.getKey();
            String mainTag = subtagTagName.get(subTag);
            Map<String,Integer> existingSubTagCountMap = tagSubTagNameCount.getOrDefault(mainTag, new HashMap<>());
            existingSubTagCountMap.put(entry.getKey(), entry.getValue());
            tagSubTagNameCount.put(mainTag, existingSubTagCountMap);
        }
        return tagSubTagNameCount;
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
