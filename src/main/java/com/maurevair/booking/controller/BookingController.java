package com.maurevair.booking.controller;

import com.maurevair.booking.dto.BookingDto;
import com.maurevair.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/save")
    public void saveBooking(@RequestBody BookingDto bookingDto) {
        bookingService.saveBooking(bookingDto);
    }
}
