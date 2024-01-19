package com.ladg.bookingservice.adapter.persistence.repository;

import com.ladg.bookingservice.adapter.persistence.entity.postgresql.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long>,
        JpaSpecificationExecutor<BookingEntity> {

    Long deleteByBookingNumber(String bookingNumber);

    BookingEntity findByBookingNumber(String bookingNumber);
}
