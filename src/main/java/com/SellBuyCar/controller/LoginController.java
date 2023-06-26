//package com.SellBuyCar.controller;
//
//import com.SellBuyCar.Interface.ILogin;
//import com.SellBuyCar.dto.LoginDto;
//import com.SellBuyCar.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class LoginController {
//    @Autowired
//    private ILogin iLogin;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
//        iLogin.login(loginDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body("4");
//
//    }
//}
