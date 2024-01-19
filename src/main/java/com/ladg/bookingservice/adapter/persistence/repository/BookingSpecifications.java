package com.ladg.bookingservice.adapter.persistence.repository;

import com.ladg.bookingservice.adapter.persistence.entity.postgresql.BookingEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

public final class BookingSpecifications {

    public static Specification<BookingEntity> hasStatus(String status) {
        return (root, query, criteriaBuilder) ->
            status == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<BookingEntity> hasBookingNumberEqual(String bookingNumber) {
        if (StringUtils.isEmpty(bookingNumber)) return null;


        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("bookingNumber"), bookingNumber);
    }

    public static Specification<BookingEntity> hasBookingNumberLike(String bookingNumber) {
        if (StringUtils.isEmpty(bookingNumber)) return null;

        return (root, query, criteriaBuilder) ->
            criteriaBuilder.like(root.get("bookingNumber"), String.format("%s%%", bookingNumber));
    }

    public static Specification<BookingEntity> hasBookingNumbers(List<String> bookingNumbers) {
        if (CollectionUtils.isEmpty(bookingNumbers)) return null;

        return (root, query, criteriaBuilder) ->
            criteriaBuilder.in(root.get("bookingNumber")).value(bookingNumbers);
    }
}