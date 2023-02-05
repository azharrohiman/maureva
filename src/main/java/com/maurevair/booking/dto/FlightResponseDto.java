package com.maurevair.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class FlightResponseDto {

    @JsonProperty("flights")
    List<FlightDto> flightDtos;
}
