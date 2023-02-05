package com.maurevair.booking.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AirportDto {
    String airportCode;
    String country;
    String region;
    String city;
}
