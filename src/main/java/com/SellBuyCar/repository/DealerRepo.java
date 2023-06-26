package com.SellBuyCar.repository;

import com.SellBuyCar.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DealerRepo extends JpaRepository<Dealer,Integer>{
    public Dealer findByEmail(String email);
    @Modifying
    @Query(value = "DELETE FROM buysellcar.dealer_profile WHERE dealer_id=:dealer_id", nativeQuery = true)
    public void DeleteById(int dealer_id);

//    @Modifying
//    @Query(value = "SELECT * FROM buysellcar.dealer where dealer_id:dealer_id", nativeQuery = true)
//    public Dealer findbyid(int id);

}
