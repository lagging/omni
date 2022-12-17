package com.creditsaison.omni.util;

import org.springframework.web.multipart.MultipartFile;

public class CSVUtil {

    public static String TYPE = "text/csv";
    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
}
