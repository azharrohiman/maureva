package com.maurevair.booking.mapper;

import com.maurevair.booking.dto.AirportDto;
import com.maurevair.booking.dto.AirportResponseDto;
import com.maurevair.booking.model.Airport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportMappingService {

    public AirportDto buildAirportDto(Airport airport) {
        return AirportDto.builder()
                .airportCode(airport.getAirportCode())
                .country(airport.getCountry())
                .city(airport.getCity())
                .region(airport.getRegion())
                .build();
    }

    public AirportResponseDto buildAirportResponseDto(List<Airport> airports) {
        return AirportResponseDto.builder()
                .airportDtos(airports.stream().map(this::buildAirportDto).collect(Collectors.toList()))
                .build();
    }
}
