package com.maurevair.booking.controller;

import com.maurevair.booking.dto.FlightResponseDto;
import com.maurevair.booking.mapper.FlightMappingService;
import com.maurevair.booking.service.FlightService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightMappingService flightMappingService;

    @GetMapping("/all-flights")
    public FlightResponseDto getAllFlights() {
        return flightMappingService.buildFlightResponseDto(flightService.fetchAllFlights());
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFlightXML(@RequestParam("file") MultipartFile file)
            throws JAXBException {
        flightService.uploadXMLFile(file);

        return ResponseEntity.ok("Flight XML file successfully saved.");
    }
}
