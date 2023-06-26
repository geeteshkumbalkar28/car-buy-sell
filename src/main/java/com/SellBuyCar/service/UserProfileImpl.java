package com.SellBuyCar.service;

import com.SellBuyCar.Interface.IUser;
import com.SellBuyCar.repository.UserprofileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileImpl implements IUser {

    @Autowired
    private UserprofileRepo userprofileRepo;

    @Override
    public void deleteById(int id) {

        userprofileRepo.deleteById(id);

    }
}
