package com.ladg.bookingservice.core.port;

import com.ladg.bookingservice.core.domain.bookingDetails.BookingDTO;

import java.util.List;

public interface BookingPort {

    List<BookingDTO> fetchBookings();

    List<BookingDTO> findByBookingNumber(String bookingNumber);

    BookingDTO saveBooking(BookingDTO bookingDTO);

    BookingDTO updateBooking(BookingDTO bookingDTO);

    void deleteBooking(String bookingNumber);


}
