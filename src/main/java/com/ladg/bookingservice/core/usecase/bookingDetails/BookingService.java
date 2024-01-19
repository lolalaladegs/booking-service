package com.ladg.bookingservice.core.usecase.bookingDetails;

import com.ladg.bookingservice.core.domain.bookingDetails.BookingDTO;
import com.ladg.bookingservice.core.port.BookingPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingService implements BookingUseCase{

    private final BookingPort bookingPort;

    @Override
    public List<BookingDTO> fetchBookings() {
        return bookingPort.fetchBookings();
    }

    @Override
    public List<BookingDTO> findByBookingNumber(String bookingNumber) {
        return bookingPort.findByBookingNumber(bookingNumber);
    }

    @Override
    public BookingDTO saveBooking(BookingDTO bookingDTO) {
        return bookingPort.saveBooking(bookingDTO);
    }

    @Override
    public BookingDTO updateBooking(BookingDTO bookingDTO) {
        return bookingPort.updateBooking(bookingDTO);
    }

    @Override
    public void deleteBooking(String bookingNumber) {
        bookingPort.deleteBooking(bookingNumber);
    }
}
