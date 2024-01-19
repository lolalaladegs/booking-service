package com.ladg.bookingservice.adapter.persistence.mapper;

import com.ladg.bookingservice.adapter.persistence.entity.postgresql.BookingEntity;
import com.ladg.bookingservice.core.domain.bookingDetails.BookingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Optional;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookingMapper {

    BookingDTO toDomain(BookingEntity entity);

    BookingEntity toEntity(BookingDTO dto);

}
