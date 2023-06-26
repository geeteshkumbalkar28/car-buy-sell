package com.SellBuyCar.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bidding")
public class Bidding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bidding_id", nullable = false)
    private int id;

    @Column(name = "bidding_status")
    private Boolean biddingStatus;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "starting_price")
    private int startingPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_car_id", nullable = false)
    private Car carCar;

    @OneToMany(mappedBy = "biddingBidding")
    private Set<Biddingbuy> biddingbuys = new LinkedHashSet<>();



}