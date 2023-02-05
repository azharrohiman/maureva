package com.maurevair.utils;

import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {

    public static final String TYPE = "text/csv";

    public static boolean validateAirportCsv(MultipartFile file) {
        return true;
    }

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }
}
