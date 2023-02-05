package com.maurevair.booking.service;

import com.maurevair.booking.model.Airport;
import com.maurevair.booking.repository.AirportRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public Optional<Airport> findAirport(String airportCode) {
        return airportRepository.findById(airportCode);
    }

    public List<Airport> findAirports() {
        return airportRepository.findAll();
    }

    public void save(MultipartFile file) {
        try {
            var airports = readCsvFile(file.getInputStream());
            airportRepository.saveAll(airports);
        }
        catch (IOException e) {

        }
    }

    public List<Airport> readCsvFile(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.builder().setHeader().build());)
        {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            var airports = new ArrayList<Airport>();

            try {
                csvRecords.forEach(csvRecord -> {
                    var airport = new Airport(
                            csvRecord.get("airportCode"),
                            csvRecord.get("country"),
                            csvRecord.get("region"),
                            csvRecord.get("city")
                    );

                    airports.add(airport);
                });

                return airports;
            }
            catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to parse CSV file:" + e.getMessage());
        }
        return null;
    }
}
