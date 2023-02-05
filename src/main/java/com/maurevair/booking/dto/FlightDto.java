package com.maurevair.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
@Builder
public class FlightDto {

    String flightId;
    String carrier;
    Long flightNumber;
    String origin;
    String destination;
    Date departureTime;
    Date arrivalTime;

    @JsonProperty("flightCabins")
    List<FlightCabinDto> flightCabinDtos;
}
