package com.ladg.bookingservice.adapter.persistence.entity.postgresql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class BookingEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -1518556788659249110L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_generator")
    @SequenceGenerator(name = "booking_generator", sequenceName = "booking_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "booking_number", length = 255)
    private String bookingNumber;

    @Column(name = "status", length = 100)
    private String status;

    @Column(name = "sender_name", length = 255)
    private String senderName;

    @Column(name = "booking_type", length = 15)
    private String bookingType;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}