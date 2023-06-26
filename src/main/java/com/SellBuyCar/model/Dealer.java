package com.SellBuyCar.model;


import com.SellBuyCar.dto.DealerDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.*;

import lombok.*;

import java.util.Set;

@Data
@Entity
@Table(name = "Dealer_Profile")
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Dealer_id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "adhar_shopact", nullable = false, length = 250)
    private String adharShopact;

    @Column(name = "area", nullable = false, length = 45)
    private String area;

    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @Column(name = "fristname", length = 45)
    private String fristname;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "mobile_no", nullable = false, length = 45)
    private String mobileNo;

    @Column(name = "shop_name", nullable = false, length = 250)
    private String shopName;
    @Column(name = "Email",nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL,targetEntity = User.class)
    private User user;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bidding_bidding_id")
    private Bidding biddingBidding;
    @JsonIgnore
    @OneToMany(mappedBy = "dealerVendor")
    private Set<Biddingbuy> biddingbuys = new LinkedHashSet<>();

//    @OneToMany(mappedBy = "dealer")
//    private List<Car> cars = new LinkedList<>();

    public Dealer() {
    }

    public Dealer(DealerDto dealerDto) {
        this.address = dealerDto.address;
        this.adharShopact = dealerDto.adharShopact;
        this.area = dealerDto.area;
        this.city =dealerDto.city;
        this.fristname = dealerDto.firstName;
        this.lastName = dealerDto.lastName;
        this.mobileNo = dealerDto.mobileNo;
        this.shopName = dealerDto.shopName;
        this.email = dealerDto.email;
    }
}