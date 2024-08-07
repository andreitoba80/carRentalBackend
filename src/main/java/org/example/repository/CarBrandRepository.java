package org.example.repository;

import org.example.entity.CarBrand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarBrandRepository extends CrudRepository<CarBrand, Long> {
    ArrayList<CarBrand> findAll();
}
