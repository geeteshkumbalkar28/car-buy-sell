package com.SellBuyCar.repository;

import com.SellBuyCar.model.User;
import com.SellBuyCar.model.Userprofile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    public User findById(int id);
/*    @Query("FROM User u WHERE u.email = :email")
    public User findByEmail(String email);
    @Query("FROM User u WHERE u.mobile_no= :mobile")
    public User findByMobile(String mobile);*/

}
