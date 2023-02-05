package com.maurevair.booking.controller;

import com.maurevair.booking.dto.AirportDto;
import com.maurevair.booking.dto.AirportResponseDto;
import com.maurevair.booking.mapper.AirportMappingService;
import com.maurevair.booking.service.AirportService;
import com.maurevair.utils.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportMappingService airportMappingService;

    @GetMapping
    public AirportDto getAirport(@RequestParam("airportCode") String airportCode) {
        var airport = airportService.findAirport(airportCode).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Airport with airportCode: " + airportCode + " does not exist."));

        return airportMappingService.buildAirportDto(airport);
    }

    @GetMapping("/all-airports")
    public AirportResponseDto getAirports() {
        return airportMappingService.buildAirportResponseDto(airportService.findAirports());
    }

    @PostMapping("/upload")
    public ResponseEntity uploadAirportCsv(@RequestParam("file") MultipartFile file) {
        if (CSVHelper.hasCSVFormat(file)) {
            if (!file.isEmpty()) {
                airportService.save(file);
            }
        }

        return null;
    }
}
