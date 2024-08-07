package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private Integer year;
    private String carSize; // Sedan, Suv, etc.
    private String manualTransmission;
    private Integer fuelType; // 0 -> Petrol, 1 -> Diesel, 2 -> Hybrid
    private Integer seatsCapacity;
    private Float pricePerDay;
    private Float rating;
    private Integer status; // -1 -> Maintenance, 0 -> Booked, 1 -> Available
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private CarBrand carBrand;
}
