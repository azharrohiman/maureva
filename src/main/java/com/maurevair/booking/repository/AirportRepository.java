package com.maurevair.booking.repository;

import com.maurevair.booking.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {

}
