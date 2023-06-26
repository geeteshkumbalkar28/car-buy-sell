package com.SellBuyCar.dto;

import lombok.*;

import javax.persistence.ExcludeDefaultListeners;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FilterDto {
private int minPrice;
private int maxPrice;
private String area;
private String brand;
private String model;
private String transmission;
private String fuelType;
private int year;
}
