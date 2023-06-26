package com.SellBuyCar.model;

import com.SellBuyCar.dto.CarDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "car")
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id", nullable = false)
    private int id;

    @Column(name = "ac_feature")
    private Boolean acFeature;

    @Column(name = "music_feature")
    private Boolean musicFeature;

    @JsonIgnore
    @Column(name = "area", length = 45)
    private String area;


    @Column(name = "`body type`", length = 45)
    private String bodyType;

    @Column(name = "brand", nullable = false, length = 45)
    private String brand;

    @Column(name = "car_insurance")
    private Boolean carInsurance;

    @Column(name = "car_status", length = 45)
    private String carStatus;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "color", length = 45)
    private String color;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "fuel_type", length = 45)
    private String fuelType;

    @Column(name = "km_driven", length = 50)
    private int kmDriven;

    @Column(name = "model", length = 45)
    private String model;

    @Column(name = "no_of_wheels")
    private int noOfWheels;

    @Column(name = "owner_serial")
    private int ownerSerial;

    @Column(name = "power_window_feature")
    private Boolean powerWindowFeature;

    @Column(name = "price", length = 45)
    private int price;

    @Column(name = "rear_parking_camera_feature")
    private Boolean rearParkingCameraFeature;

    @Column(name = "registration", length = 45)
    private String registration;

    @Column(name = "safety_description", length = 250)
    private String safetyDescription;

    @Column(name = "transmission", length = 45)
    private String transmission;

    @Column(name = "tyre", length = 45)
    private String tyre;

    @Column(name = "year")
    private int year;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "dealer_id", nullable = false)
//    private Dealer dealer;
    private int dealer_id;
    @JsonIgnore
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Carphoto> carphotos = new LinkedHashSet<>();
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "dealer_bidding", joinColumns = @JoinColumn(name = "dealer_id"),
    inverseJoinColumns = @JoinColumn(name = "bidding_id"))
    private Set<Bidding> biddings = new LinkedHashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "carCar")
    private Set<PendingBooking> pendingBookings = new LinkedHashSet<>();

    public Car(CarDto carDto){
        this.acFeature = carDto.getAcFeature();
        this.musicFeature =carDto.getMusicFeature();
        this.area =carDto.getArea();
        this.bodyType = carDto.getBodyType();
        this.brand = carDto.getBrand();
        this.carInsurance = carDto.getCarInsurance();
        this.carStatus = carDto.getCarStatus();
        this.city = carDto.getCity();
        this.color = carDto.getColor();
        this.description =carDto.getDescription();
        this.fuelType = carDto.getFuelType();
        this.kmDriven = carDto.getKmDriven();
        this.model = carDto.getModel();
        this.noOfWheels = carDto.getNoOfWheels();
        this.ownerSerial = carDto.getOwnerSerial();
        this.powerWindowFeature = carDto.getPowerWindowFeature();
        this.price =carDto.getPrice();
        this.rearParkingCameraFeature = carDto.getRearParkingCameraFeature();
        this.registration = carDto.getRegistration();
        this.safetyDescription = carDto.getSafetyDescription();
        this.transmission = carDto.getTransmission();
        this.tyre = carDto.getTyre();
        this.year = carDto.getYear();
        this.dealer_id=carDto.getDealer_id();
    }
}