package com.ladg.bookingservice.adapter.web.controller;

import com.ladg.bookingservice.core.domain.bookingDetails.BookingDTO;
import com.ladg.bookingservice.core.usecase.bookingDetails.BookingUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/v1/book", produces = {MediaType.APPLICATION_JSON_VALUE})
public class BookingController {

    private final BookingUseCase bookingUseCase;

    @GetMapping(value = "/")
    private ResponseEntity<List<BookingDTO>> fetchBookings(){
        log.info("Retrieving bookings...");
        List<BookingDTO> bookingList = bookingUseCase.fetchBookings();
        return ResponseEntity.ok(bookingList);
    }

    @GetMapping(value = "/{bookingNumber}")
    private ResponseEntity<List<BookingDTO>> findByBookingNumber(@PathVariable("bookingNumber") final String bookingNumber){
        log.info("Retrieving booking details for booking number {}", bookingNumber);
        List<BookingDTO> bookingList = bookingUseCase.findByBookingNumber(bookingNumber);
        return ResponseEntity.ok(bookingList);
    }

    @PostMapping(value = "/")
    private ResponseEntity<BookingDTO> saveBooking(@RequestBody final BookingDTO booking){
        log.info("Saving booking details for booking number {}", booking.getBookingNumber());
        BookingDTO bookingDTO = bookingUseCase.saveBooking(booking);
        return ResponseEntity.ok(bookingDTO);
    }

    @PutMapping(value = "/")
    private ResponseEntity<BookingDTO> updateBooking(@RequestBody final BookingDTO booking){
        log.info("Updating booking details for booking number {}", booking.getBookingNumber());
        BookingDTO bookingDTO = bookingUseCase.updateBooking(booking);
        return ResponseEntity.ok(bookingDTO);
    }

    @DeleteMapping(value = "/{bookingNumber}")
    private ResponseEntity<String> deleteBooking(@PathVariable("bookingNumber") final String bookingNumber){
        log.info("Deleting booking with booking number {}", bookingNumber);
        bookingUseCase.deleteBooking(bookingNumber);
        return ResponseEntity.ok("Successfully deleted booking number "+bookingNumber);
    }
}
