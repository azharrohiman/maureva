package com.maurevair.booking.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FlightCabinDto {

    Long id;
    String cabinClass;
    Long seatsAvailable;
}
