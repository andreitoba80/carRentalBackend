package org.example.service;

import org.example.dto.AddCarBrandDto;
import org.example.entity.CarBrand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface CarBrandService {
    ArrayList<CarBrand> getAllCarBrands();

    void addCarBrand(AddCarBrandDto addCarBrandDto, String imageUrl) throws Exception;
}
