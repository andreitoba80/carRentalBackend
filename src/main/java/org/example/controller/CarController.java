package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.AddCarDto;
import org.example.service.CarImageService;
import org.example.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@AllArgsConstructor
public class CarController implements CarControllerResource {
    private final CarService carService;
    private final CarImageService carImageService;

    @Override
    public ResponseEntity<String> addCar(AddCarDto addCarDto) throws Exception {

        carService.addCar(addCarDto);

        return ResponseEntity.ok().body("Car listing added successfully");
    }

    @Override
    public ResponseEntity<String> uploadCarPhoto(MultipartFile file, Long carId) {
        try {
            var imageUrl = carImageService.addImage(file);

            carService.updateCarImage(imageUrl, carId);

            return ResponseEntity.status(200).body("Added Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getAllCars() {
        try {
            var carList = carService.getAllCars();
            return ResponseEntity.status(200).body(carList);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
