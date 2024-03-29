package com.SellBuyCar.service;


import com.SellBuyCar.Interface.ICarRegister;
import com.SellBuyCar.dto.CarDto;
import com.SellBuyCar.dto.FilterDto;
import com.SellBuyCar.dto.ResponceCarDto;
import com.SellBuyCar.exception.CarNotFoundException;
import com.SellBuyCar.exception.DealerNotFoundException;
import com.SellBuyCar.model.Car;
import com.SellBuyCar.model.Carphoto;
import com.SellBuyCar.model.Dealer;
import com.SellBuyCar.model.User;
import com.SellBuyCar.repository.CarRepo;
import com.SellBuyCar.repository.DealerRepo;
import com.SellBuyCar.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CarRegisterImp implements ICarRegister {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private DealerRepo dealerRepo;



    @Override
    public String AddCarDetails(CarDto carDto) {
        System.out.println(carDto.getDealer_id());
        Dealer dealer=dealerRepo.findById(carDto.getDealer_id()).orElseThrow(()->new CarNotFoundException("Dealer Not Found For ID "+carDto.getDealer_id()));
        System.out.println(dealer.toString());
//        List<Car> dealerCar = new ArrayList<>();


              Car car =new Car(carDto);
//              car.setDealer(dealer);
//              dealerCar=dealer.getCars();

//              dealer.setCars(dealerCar);
//              dealerRepo.save(dealer);
              carRepo.save(car);
              return "car Added";


//        System.out.println("4");

//        byte encrypt[]= Base64.getEncoder().encode(dealerDto.password.getBytes());
//        String encryptPassword=new String(encrypt);


    }

    @Override
    public String editCarDetails(CarDto carDto, int id) {
        System.err.println(carDto.getCarStatus()+""+id);
        Car car = carRepo.findById(id).orElseThrow(()->new CarNotFoundException("car not found"));
//        System.err.println(car.toString());


            System.err.println();
        car.setAcFeature(carDto.getAcFeature());
        car.setMusicFeature(carDto.getMusicFeature());
        car.setArea(carDto.getArea());
        car.setBodyType(carDto.getBodyType());
        car.setBrand(carDto.getBrand());
        car.setCarInsurance(carDto.getCarInsurance());
        car.setCarStatus(carDto.getCarStatus());
        car.setCity(carDto.getCity());
        car.setColor(carDto.getColor());
        car.setDescription(carDto.getDescription());
        car.setFuelType(carDto.getFuelType());
        car.setKmDriven(carDto.getKmDriven());
        car.setModel(carDto.getModel());
        car.setNoOfWheels(carDto.getNoOfWheels());
        car.setPowerWindowFeature(carDto.getPowerWindowFeature());
        car.setOwnerSerial(carDto.getOwnerSerial());
        car.setPowerWindowFeature(carDto.getPowerWindowFeature());
        car.setPrice(carDto.getPrice());
        car.setRearParkingCameraFeature(carDto.getRearParkingCameraFeature());
        car.setRegistration(carDto.getRegistration());
        car.setSafetyDescription(carDto.getSafetyDescription());
        car.setTransmission(carDto.getTransmission());
        car.setTyre(carDto.getTyre());
        car.setYear(carDto.getYear());

        carRepo.save(car);
        return "Car Updated"+id;
     }


    @Override
    public List<CarDto> getAllCarsWithPages(int PageNo) {
//        carRepo.findById(carId).orElseThrow(()-> new CarNotFoundException("car not found"));
        List<Car> listOfCar = carRepo.findAll();
        System.out.println("list of de"+listOfCar.size());
        List<CarDto> listOfCarDto = new ArrayList<>();
//        System.out.println("2");
        int pageStart=PageNo*10;
        int pageEnd=pageStart+10;
        int diff=(listOfCar.size()) - pageStart;
//        for(int counter=pageNo*10;counter<(pageNo*10)+10;counter++){
        for(int counter=pageStart,i=1;counter<pageEnd;counter++,i++){
            if(pageStart>listOfCar.size()){break;}

            System.out.println("*");
            CarDto carDto = new CarDto(listOfCar.get(counter));
//            System.out.println(responseDealerDto.toString());
            listOfCarDto.add(carDto);
//            System.out.println(listOfDealerDto.size());
            if(diff == i){
                break;
            }
        }
//                   ResponseDealerDto responseDealerDto = new ResponseDealerDto(listOfDealer.get(1));

        System.out.println(listOfCar);
        return listOfCarDto;
    }

    @Override
    public String deleteCar(int id) {
        Car carDetail = carRepo.findById(id).orElseThrow(()->new CarNotFoundException("car Id not found"));
        carRepo.deleteById(id);
        return "car details deleted ";
    }
    @Override
    public Optional<List<Car>> FindByArea(String area) {
        Optional<List<Car>> cars = carRepo.FindByArea(area);
        if (cars.isPresent()) {

            try {

                return cars;

            } catch (Exception r)
            {
                System.err.println(r);
            }
        } else {
            System.err.println("car is not present");

        }
//        System.out.println("11");
//        return carRepo.FindByArea(area);
        return cars;
    }

    @Override
    public List<CarDto> searchByFilter(FilterDto filterDto,int pageNo) {
        List<Car> listOfCar =carRepo.findCarsByParameters(filterDto.getMinPrice(),filterDto.getMaxPrice(),filterDto.getArea(),filterDto.getYear(),filterDto.getBrand(),filterDto.getModel(),filterDto.getTransmission(),filterDto.getFuelType()).orElseThrow(()->new CarNotFoundException("car not found"));
        System.err.println("Filter **********"+filterDto.toString());
        System.out.println("list of de"+listOfCar.size());
        List<CarDto> listOfCarDto = new ArrayList<>();
//        System.out.println("2");
        int pageStart=pageNo*10;
        int pageEnd=pageStart+10;
        int diff=(listOfCar.size()) - pageStart;
        if(diff ==0){
            return listOfCarDto;
        }
//        for(int counter=pageNo*10;counter<(pageNo*10)+10;counter++){
        for(int counter=pageStart,i=1;counter<pageEnd;counter++,i++){
            if(pageStart>listOfCar.size()){break;}

            System.out.println("*");
            CarDto carDto = new CarDto(listOfCar.get(counter));
//            System.out.println(responseDealerDto.toString());
            listOfCarDto.add(carDto);
//            System.out.println(listOfDealerDto.size());
            if(diff == i){
                break;
            }
        }
//                   ResponseDealerDto responseDealerDto = new ResponseDealerDto(listOfDealer.get(1));

        System.out.println(listOfCar);
        return listOfCarDto;
    }
}
