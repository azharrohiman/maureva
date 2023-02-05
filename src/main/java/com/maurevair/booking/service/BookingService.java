package com.maurevair.booking.service;

import com.maurevair.booking.dto.BookingDto;
import com.maurevair.booking.model.Booking;
import com.maurevair.booking.repository.BookingRepository;
import com.maurevair.booking.repository.FlightCabinRepository;
import com.maurevair.booking.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightCabinRepository flightCabinRepository;

    public void saveBooking(BookingDto bookingDto) {
        var flightCabin = flightCabinRepository.findFlightCabinByCabinClassAndFlight_FlightId(bookingDto.getCabinClass(),
                bookingDto.getFlightId()).orElseThrow();

        var user = userRepository.findByEmail(bookingDto.getEmail()).orElseThrow();

        Booking booking = new Booking();

        booking.setUser(user);
        booking.setFlightCabin(flightCabin);

        flightCabin.setSeatsAvailable(flightCabin.getSeatsAvailable()-1);
        flightCabinRepository.save(flightCabin);

        bookingRepository.save(booking);
    }
}
