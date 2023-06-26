package com.SellBuyCar.controller;


import com.SellBuyCar.Interface.ICarRegister;
import com.SellBuyCar.dto.CarDto;
import com.SellBuyCar.dto.ResponceCarDto;
import com.SellBuyCar.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarRegister iCarRegister;

    @PostMapping(value = "/carregister")
    public ResponseEntity<String> carRegistration(@RequestBody CarDto carDto) {
        String result = iCarRegister.AddCarDetails(carDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> carEdit(@RequestBody CarDto carDto, @PathVariable int id) {
        String result = iCarRegister.editCarDetails(carDto, id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getAllCars")
    public List<CarDto> getAllCars(@RequestParam int pageNo){
        return iCarRegister.getAllCarsWithPages(pageNo);
    }

    @DeleteMapping("/removeCar")
    public String deleteCar(@RequestParam int carId){
        return iCarRegister.deleteCar(carId);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Car>> findByArea(@RequestParam("area") String area) {
        Optional<List<Car>> cars = iCarRegister.FindByArea(area);
        System.out.println("00");
//        System.out.println(cars.get().get(0).getArea());
        return ResponseEntity.ok(cars.get());
    }

}



