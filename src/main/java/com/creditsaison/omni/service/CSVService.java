package com.creditsaison.omni.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CSVService {

    boolean save(MultipartFile file) throws IOException;
}
