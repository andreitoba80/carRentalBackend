package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddCarDto {
    private String model;
    private Integer year;
    private String carSize;
    private String manualTransmission;
    private Integer fuelType;
    private Integer seatsCapacity;
    private Float pricePerDay;
    private Float rating;
    private Integer status = 1;
}
