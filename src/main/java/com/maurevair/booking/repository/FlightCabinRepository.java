package com.maurevair.booking.repository;

import com.maurevair.booking.model.FlightCabin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightCabinRepository extends JpaRepository<FlightCabin, Long> {

    Optional<FlightCabin> findFlightCabinByCabinClassAndFlight_FlightId(String cabinClass, String flightId);
}
