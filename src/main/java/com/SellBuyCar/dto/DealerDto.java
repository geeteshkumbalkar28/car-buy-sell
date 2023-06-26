package com.SellBuyCar.dto;

import com.SellBuyCar.model.Bidding;
import com.SellBuyCar.model.User;
//import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DealerDto {
    public String address;

    public String adharShopact;

    public String area;

    public String city;

    public String firstName;

    public String lastName;

    public String mobileNo;

    public String shopName;
    public String email;
    public String password;


}
