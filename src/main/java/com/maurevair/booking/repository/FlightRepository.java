package com.maurevair.booking.repository;

import com.maurevair.booking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, String> {

    @Query("SELECT f FROM Flight f INNER JOIN FlightCabin fc ON f.flightId = fc.flight.flightId")
    List<Flight> findAllFlights();
}
