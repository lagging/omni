package com.creditsaison.omni.service;

import com.creditsaison.omni.pojos.BatchesNPSInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CSVService {

    boolean save(MultipartFile file) throws IOException;

    BatchesNPSInfo parseCSV(MultipartFile file) throws IOException;

    BatchesNPSInfo parseManualCsv(MultipartFile file) throws IOException;
}
