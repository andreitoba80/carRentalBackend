package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.AddCarBrandDto;
import org.example.entity.CarBrand;
import org.example.repository.CarBrandRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CarBrandServiceImpl implements CarBrandService {
    private CarBrandRepository carBrandRepository;

    @Override
    public ArrayList<CarBrand> getAllCarBrands() {
        return carBrandRepository.findAll();
    }

    @Override
    public void addCarBrand(AddCarBrandDto addCarBrandDto, String imageUrl) throws Exception {
        var carBrand = new CarBrand();
        try {
            carBrand.setBrand(addCarBrandDto.getBrand());
            carBrand.setBrandImageUrl(imageUrl);

            carBrandRepository.save(carBrand);
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }
}
