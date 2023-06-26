package com.SellBuyCar.Interface;


import com.SellBuyCar.dto.CarDto;
import com.SellBuyCar.dto.ResponceCarDto;
import com.SellBuyCar.model.Car;

import javax.swing.plaf.PanelUI;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ICarRegister {
    public String AddCarDetails(CarDto carDto);
    public String editCarDetails(CarDto carDto,int id);
    public List<CarDto> getAllCarsWithPages(int PageNo);
    public String deleteCar(int id);


    public Optional<List<Car>> FindByArea(String area);


}
