package org.example.repository;

import org.example.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    Car findCarById(Long carId);

    ArrayList<Car> findAll();
}
