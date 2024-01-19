package com.ladg.bookingservice.core.usecase.bookingDetails;

import com.ladg.bookingservice.core.domain.bookingDetails.BookingDTO;

import java.util.List;

public interface BookingUseCase {

    List<BookingDTO> fetchBookings();

    List<BookingDTO> findByBookingNumber(String bookingNumber);

    BookingDTO saveBooking(BookingDTO bookingDTO);

    BookingDTO updateBooking(BookingDTO bookingDTO);

    void deleteBooking(String bookingNumber);

}
