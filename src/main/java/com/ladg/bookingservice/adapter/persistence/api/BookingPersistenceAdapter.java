package com.ladg.bookingservice.adapter.persistence.api;

import com.ladg.bookingservice.adapter.persistence.entity.postgresql.BookingEntity;
import com.ladg.bookingservice.adapter.persistence.mapper.BookingMapper;
import com.ladg.bookingservice.adapter.persistence.repository.BookingRepository;
import com.ladg.bookingservice.core.domain.bookingDetails.BookingDTO;
import com.ladg.bookingservice.core.port.BookingPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

import static com.ladg.bookingservice.adapter.persistence.repository.BookingSpecifications.hasBookingNumberEqual;

@Component
@Slf4j
@RequiredArgsConstructor
public class BookingPersistenceAdapter implements BookingPort {

    private final BookingRepository bookingRepository;

    private final BookingMapper bookingMapper;

    @Override
    public List<BookingDTO> fetchBookings() {
        List<BookingEntity> bookingEntity = bookingRepository.findAll();
        return bookingEntity
                .stream()
                .sorted(Comparator.comparing(BookingEntity::getUpdatedAt).reversed())
                .map(bookingMapper::toDomain)
                .toList();
    }

    @Override
    public List<BookingDTO> findByBookingNumber(String bookingNumber) {
        Specification<BookingEntity> spec = buildSpecification(bookingNumber);

        List<BookingEntity> bookingEntity = bookingRepository.findAll(spec);
        return bookingEntity
                .stream()
                .sorted(Comparator.comparing(BookingEntity::getUpdatedAt).reversed())
                .map(bookingMapper::toDomain)
                .toList();
    }

    @Override
    @Modifying
    @Transactional
    public BookingDTO saveBooking(BookingDTO bookingDTO) {
        BookingEntity bookingEntity = bookingMapper.toEntity(bookingDTO);
        BookingEntity bookingResponse = bookingRepository.save(bookingEntity);
        return bookingMapper.toDomain(bookingResponse);
    }

    @Override
    @Modifying
    @Transactional
    public BookingDTO updateBooking(BookingDTO bookingDTO) {
        BookingEntity bookingEntity = bookingMapper.toEntity(bookingDTO);

        BookingEntity bookingDetailsResponse = bookingRepository.findByBookingNumber(bookingDTO.getBookingNumber());
        if ( bookingDetailsResponse != null ) {
            bookingEntity.setId(bookingDetailsResponse.getId());
        }

        BookingEntity bookingResponse = bookingRepository.save(bookingEntity);
        return bookingMapper.toDomain(bookingResponse);
    }

    @Override
    @Modifying
    @Transactional
    public void deleteBooking(String bookingNumber) {
        Long bookingResponse = bookingRepository.deleteByBookingNumber(bookingNumber);
        log.info("Successfully deleted booking number {}. New booking count is {}", bookingNumber, bookingResponse);
    }

    private Specification<BookingEntity> buildSpecification(String bookingNumber) {

        Specification<BookingEntity> specification = Specification.where(null);

        specification = specification.and(
                hasBookingNumberEqual(bookingNumber));

        return specification;
    }
}
