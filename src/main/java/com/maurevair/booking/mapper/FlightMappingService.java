package com.maurevair.booking.mapper;

import com.maurevair.booking.dto.FlightCabinDto;
import com.maurevair.booking.dto.FlightDto;
import com.maurevair.booking.dto.FlightResponseDto;
import com.maurevair.booking.model.Flight;
import com.maurevair.booking.model.FlightCabin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightMappingService {

    public FlightDto buildFlightDto(Flight flight) {
        return FlightDto.builder()
                .flightId(flight.getFlightId())
                .carrier(flight.getCarrier())
                .flightNumber(flight.getFlightNumber())
                .origin(flight.getOrigin())
                .destination(flight.getDestination())
                .departureTime(flight.getDepartureTime())
                .arrivalTime(flight.getArrivalTime())
                .flightCabinDtos(buildFlightCabinDto(flight.getFlightCabins()))
                .build();
    }

    public List<FlightCabinDto> buildFlightCabinDto(List<FlightCabin> flightCabins) {
        return flightCabins.stream().map(flightCabin -> FlightCabinDto.builder()
                .id(flightCabin.getFlightCabinKey())
                .cabinClass(flightCabin.getCabinClass())
                .seatsAvailable(flightCabin.getSeatsAvailable())
                .build()).collect(Collectors.toList());
    }

    public FlightResponseDto buildFlightResponseDto(List<Flight> flights) {
        return FlightResponseDto.builder()
                .flightDtos(flights.stream().map(this::buildFlightDto).collect(Collectors.toList()))
                .build();
    }
}
