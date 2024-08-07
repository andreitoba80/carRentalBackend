package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.AddCarDto;
import org.example.entity.Car;
import org.example.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CarServiceImplementation implements CarService {
    private final CarRepository carRepository;
    private final CarImageService carImageService;

    @Override
    public void addCar(AddCarDto addCarDto) throws Exception {
        var car = new Car();
        try {
            car.setModel(addCarDto.getModel());
            car.setYear(addCarDto.getYear());
            car.setCarSize(addCarDto.getCarSize());
            car.setManualTransmission(addCarDto.getManualTransmission());
            car.setFuelType(addCarDto.getFuelType());
            car.setSeatsCapacity(addCarDto.getSeatsCapacity());
            car.setPricePerDay(addCarDto.getPricePerDay());
            car.setRating(addCarDto.getRating());
            car.setStatus(addCarDto.getStatus());

            carRepository.save(car);
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    @Override
    public void updateCarImage(String url, Long carId) throws Exception {
        var carData = carRepository.findCarById(carId);
        if (carData != null) {
            carData.setImageUrl(url);
            carRepository.save(carData);
        } else {
            throw new Exception("Car does not exist");
        }
    }

    @Override
    public ArrayList<Car> getAllCars() {
        return carRepository.findAll();
    }
}
