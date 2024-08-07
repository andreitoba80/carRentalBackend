package org.example.controller;

import org.example.dto.AddCarBrandDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/carBrands")
public interface CarBrandControllerResource {
    @GetMapping(value = "getAllCarBrands")
    ResponseEntity<?> getAllCarBrands();

    @PostMapping(value = "addCarBrand")
    ResponseEntity<String> addCarBrand(@ModelAttribute AddCarBrandDto addCarBrandDto, @RequestParam("file") MultipartFile file) throws Exception;
}
