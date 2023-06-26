package com.SellBuyCar.service;

import com.SellBuyCar.Interface.IDealer;
import com.SellBuyCar.dto.DealerDto;
import com.SellBuyCar.dto.ResponseDealerDto;
import com.SellBuyCar.model.Dealer;
import com.SellBuyCar.model.User;
import com.SellBuyCar.repository.DealerRepo;
import com.SellBuyCar.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class DealerImp implements IDealer {
    @Autowired
    private DealerRepo dealerRepo;
    @Autowired
    private UserRepo userRepo;


    /////////////////////////////////////////////////////////////////////
    //
    //  Method Name :  adDealer
    //  Description   :  Used to Registeration The Dealer And It's Profile
    //  Input         :  DealerDto
    //  Output        :  String
    //  Date 		  :  20/06/2023
    //  Author 		  :  Geetesh Gajanan Kumbalkar
    //
    /////////////////////////////////////////////////////////////////////
    @Override
    public String adDealer(DealerDto dealerDto) {
//        System.out.println("3");
//        Dealer dealer = dealerRepo.findByEmail(dealerDto.email);
//        System.out.println("55");
//        if(dealer!=null){
//            return "Email is all ready Exist";
//        }
//        dealerRepo.findById(dealerDto)
        User user=new User();
//        System.out.println("4");

        byte encrypt[]= Base64.getEncoder().encode(dealerDto.password.getBytes());
        String encryptPassword=new String(encrypt);

        user.setPassword(encryptPassword);
        user.setEmail(dealerDto.email);
        user.setMobileNo(dealerDto.mobileNo);

        Dealer dealerData=new Dealer(dealerDto);

        dealerData.setUser(user);
//        user.setDealers(dealerData);

        System.out.println(user.toString());
        System.out.println(dealerData.toString());
//        userRepo.save(user);
        System.out.println(" Getting ");
        dealerRepo.save(dealerData);
        return "Dealer Added";
    }
    /////////////////////////////////////////////////////////////////////
    //
    //  Method Name    :  getDealers
    //  Description   :  Used to Get The all Dealers with pagewise
    //  Input         :  int
    //  Output        :  List<ResponseDealerDto>
    //  Date 		  :  21/06/2023
    //  Author 		  :  Geetesh Gajanan Kumbalkar
    //
    /////////////////////////////////////////////////////////////////////

    @Override
    public List<ResponseDealerDto> getDealers(int pageNo) {
        List<Dealer> listOfDealer = dealerRepo.findAll();
        System.out.println("list of de"+listOfDealer.size());
        List<ResponseDealerDto> listOfDealerDto = new ArrayList<>();
//        System.out.println("2");
        int pageStart=pageNo*10;
        int pageEnd=pageStart+10;
        int diff=(listOfDealer.size()) - pageStart;
//        for(int counter=pageNo*10;counter<(pageNo*10)+10;counter++){
        for(int counter=pageStart,i=1;counter<pageEnd;counter++,i++){
            if(pageStart>listOfDealer.size()){break;}

            System.out.println("*");
            ResponseDealerDto responseDealerDto = new ResponseDealerDto(listOfDealer.get(counter));
//            System.out.println(responseDealerDto.toString());
            listOfDealerDto.add(responseDealerDto);
//            System.out.println(listOfDealerDto.size());
            if(diff == i){
                 break;
            }
        }
//                   ResponseDealerDto responseDealerDto = new ResponseDealerDto(listOfDealer.get(1));

        System.out.println(listOfDealerDto);
        return listOfDealerDto;

    }
    /////////////////////////////////////////////////////////////////
    //
    //  Method Name   :  editDealer
    //  Description   :  Used to edit The Dealer details
    //  Input         :  DealerDto,int
    //  Output        :  String
    //  Date 		  :  21/06/2023
    //  Author 		  :  Geetesh Gajanan Kumbalkar
    //
    /////////////////////////////////////////////////////////////////////

    @Override
    public String editDealer(DealerDto dealerDto,int id) {

        Optional<Dealer> dealer = dealerRepo.findById(id);
        if(dealer.isPresent()){
            dealer.get().setFristname(dealerDto.firstName);
            dealer.get().setLastName(dealerDto.lastName);
            dealer.get().setAddress(dealerDto.address);
            dealer.get().setMobileNo(dealerDto.mobileNo);
            dealer.get().setEmail(dealerDto.email);
            dealer.get().getUser().setMobileNo(dealerDto.mobileNo);
            byte encrypt[]= Base64.getEncoder().encode(dealerDto.password.getBytes());
            String encryptPassword=new String(encrypt);
            dealer.get().getUser().setPassword(encryptPassword);

            dealer.get().getUser().setEmail(dealerDto.email);
            dealer.get().setArea(dealerDto.area);
            dealer.get().setCity(dealerDto.city);

            dealerRepo.save(dealer.get());
            return "Added dealer :"+id;
        }
        return "invalid id";
    }
    /////////////////////////////////////////////////////////////////////
    //
    //  Method Name   :  removeDealers
    //  Description   :  Used to remove The Dealer details
    //  Input         :  int
    //  Output        :  String
    //  Date 		  :  21/06/2023
    //  Author 		  :  Geetesh Gajanan Kumbalkar
    //
    /////////////////////////////////////////////////////////////////////

    @Override
    @Transactional
    public String removeDealers(int id) {
        Optional<Dealer> dealer = dealerRepo.findById(id);
        if(dealer.isPresent()){
            try {
                dealerRepo.DeleteById(id);
                return "dealer Delete Succesfully :"+ id;
            }catch (Exception e){
                System.err.println(e);
            }

        }
        return "id invalid";
    }
}
