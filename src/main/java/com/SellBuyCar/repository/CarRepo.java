package com.SellBuyCar.repository;

import com.SellBuyCar.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepo extends JpaRepository<Car,Integer> {
//    public Car findById(int id);
    //    @Query("SELECT c FROM Car c WHERE c.area = :area")
    @Query(value = "SELECT * FROM car WHERE area = ?1", nativeQuery = true)
    Optional<List<Car>> FindByArea(@Param("area") String area);
//    @Modifying
//    @Query(value = "DELETE FROM buysellcar.dealer_profile WHERE dealer_id=:dealer_id", nativeQuery = true)
//    public void DeleteById(int dealer_id);
//    @Modifying
    @Query(value = "select * from buysellcar.car where price > :minPrice and price < :maxPrice and area = :area and year = :year and brand = :brand and model = :model and transmission = :transmission and fuelType = :fuelType",nativeQuery = true)
    Optional<List<Car>> findByCarFilter(int minPrice,int maxPrice,String area,int year,String brand,String model,String transmission,String fuelType);
}
