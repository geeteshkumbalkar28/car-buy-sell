package com.SellBuyCar.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "price", length = 45)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pending_booking_pending_booking", nullable = false)
    private PendingBooking pendingBookingPendingBooking;

}