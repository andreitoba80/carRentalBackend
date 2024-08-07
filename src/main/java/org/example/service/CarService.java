package org.example.service;

import org.example.dto.AddCarDto;
import org.example.entity.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface CarService {

    void addCar(AddCarDto addCarDto) throws Exception;

    void updateCarImage(String url, Long carId) throws Exception;

    ArrayList<Car> getAllCars();
}
