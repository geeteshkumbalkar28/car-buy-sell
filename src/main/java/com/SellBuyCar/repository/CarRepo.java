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
    @Query("SELECT c FROM Car c WHERE c.price > :minPrice OR c.price < :maxPrice OR c.area = :area OR c.year = :year OR c.brand = :brand OR c.model = :model OR c.transmission = :transmission OR c.fuelType = :fuelType")
    Optional<List<Car>> findCarsByParameters(@Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice, @Param("area") String area, @Param("year") int year, @Param("brand") String brand, @Param("model") String model, @Param("transmission") String transmission, @Param("fuelType") String fuelType);
}
