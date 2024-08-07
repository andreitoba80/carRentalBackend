package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.AddCarBrandDto;
import org.example.service.CarBrandImageService;
import org.example.service.CarBrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@AllArgsConstructor
public class CarBrandController implements CarBrandControllerResource {
    private CarBrandService carBrandService;
    private CarBrandImageService carBrandImageService;

    @Override
    public ResponseEntity<?> getAllCarBrands() {
        try {
            var carBandsList = carBrandService.getAllCarBrands();
            System.out.println("LOG: CarBrandsList = " + carBandsList);
            return ResponseEntity.status(200).body(carBandsList);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> addCarBrand(AddCarBrandDto addCarBrandDto, MultipartFile file) {
        try {
            var imageUrl = carBrandImageService.addImage(file);

            carBrandService.addCarBrand(addCarBrandDto, imageUrl);

            return ResponseEntity.status(200).body("Car Brand Added Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
