package org.example.controller;

import org.example.dto.AddCarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/car")
public interface CarControllerResource {

    @PostMapping(value = "addCar")
    ResponseEntity<String> addCar(@RequestBody AddCarDto addCarDto) throws Exception;

    @PostMapping(value = "addImage/{carId}")
    ResponseEntity<String> uploadCarPhoto(@RequestParam("file") MultipartFile file, @PathVariable Long carId);

    @GetMapping(value = "getAllCars")
    ResponseEntity<?> getAllCars();
}
