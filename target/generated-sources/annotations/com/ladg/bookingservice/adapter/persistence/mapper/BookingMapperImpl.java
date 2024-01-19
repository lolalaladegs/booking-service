package com.ladg.bookingservice.adapter.persistence.mapper;

import com.ladg.bookingservice.adapter.persistence.entity.postgresql.BookingEntity;
import com.ladg.bookingservice.core.domain.bookingDetails.BookingDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T21:29:00+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingDTO toDomain(BookingEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setBookingNumber( entity.getBookingNumber() );
        bookingDTO.setStatus( entity.getStatus() );
        bookingDTO.setSenderName( entity.getSenderName() );
        bookingDTO.setBookingType( entity.getBookingType() );
        bookingDTO.setUpdatedAt( entity.getUpdatedAt() );

        return bookingDTO;
    }

    @Override
    public BookingEntity toEntity(BookingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setBookingNumber( dto.getBookingNumber() );
        bookingEntity.setStatus( dto.getStatus() );
        bookingEntity.setSenderName( dto.getSenderName() );
        bookingEntity.setBookingType( dto.getBookingType() );
        bookingEntity.setUpdatedAt( dto.getUpdatedAt() );

        return bookingEntity;
    }
}
