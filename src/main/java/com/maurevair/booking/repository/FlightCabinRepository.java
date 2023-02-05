package com.maurevair.booking.repository;

import com.maurevair.booking.model.FlightCabin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightCabinRepository extends JpaRepository<FlightCabin, Long> {

}
