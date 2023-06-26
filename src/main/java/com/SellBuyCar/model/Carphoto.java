package com.SellBuyCar.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carphoto")
public class Carphoto {
    @Id
    @Column(name = "car_photo_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "PhotoLink", length = 250)
    private String PhotoLink;

    @Column(name = "PhotoType", length = 250)
    private String PhotoType;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;


}