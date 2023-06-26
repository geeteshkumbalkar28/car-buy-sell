package com.SellBuyCar.controller;

import com.SellBuyCar.Interface.IUser;
import com.SellBuyCar.repository.UserprofileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUser userProfile;

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam int id){

        userProfile.deleteById(id);
        return null;
    }
}
