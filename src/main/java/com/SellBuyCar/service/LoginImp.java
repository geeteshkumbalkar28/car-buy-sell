//package com.SellBuyCar.service;
//
//import com.SellBuyCar.Interface.ILogin;
//import com.SellBuyCar.dto.LoginDto;
//import com.SellBuyCar.model.User;
//import com.SellBuyCar.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Base64;
//import java.util.List;
//@Service
//public class LoginImp implements ILogin {
//    @Autowired
//    private UserRepo userRepo;
//    @Override
//    public String login(LoginDto loginDto) {
//        List<User> UserList=userRepo.findAll();
//        User user;
//        byte decrypt[]= Base64.getDecoder().decode(loginDto.password.getBytes());
//        String encryptPassword=new String(decrypt);
////        if((loginDto.email).length()>0){
////            user=userRepo.findByEmail(loginDto.email);
////            if((loginDto.password).equals(encryptPassword)){
////                return "login successful";
////            }
////        }
////        else if((loginDto.mobileNo).length()>0){
////            user=userRepo.findByMobile(loginDto.mobileNo);
////            if((loginDto.password).equals(encryptPassword)){
////                return "login successful";
////            }
////        }
//        return "Login failed";
//
//
//    }
//}
