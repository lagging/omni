package com.creditsaison.omni.controllers;

import com.creditsaison.omni.service.CSVService;
import com.creditsaison.omni.util.CSVUtil;
import com.creditsaison.omni.util.exception.CSException;
import com.creditsaison.omni.util.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/v1/csv")
public class CSVController extends BaseController {

    @Autowired
    private CSVService csvService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws CSException {
        if (!CSVUtil.hasCSVFormat(file)) {
            throw new CSException(ErrorCode.BAD_REQUEST_ERROR, "Please provide csv file");
        }
        return this.executeTask(() -> csvService.save(file));
    }
}
