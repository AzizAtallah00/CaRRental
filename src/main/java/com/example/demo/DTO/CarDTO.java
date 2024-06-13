package com.example.demo.DTO;

import java.util.List;

import com.example.demo.Enum.CarType;
import com.example.demo.Enum.FuelType;
import com.example.demo.Enum.TransmissionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;

public class CarDTO extends BaseDTO{
    @NotBlank
    private String model;
    @NotBlank
    // @Enumerated(EnumType.STRING)
    private CarType type;
    @NotBlank
    private int capacity;
    @NotBlank
    // @Enumerated(EnumType.STRING)
    private TransmissionType transmission; 
    @NotBlank
    // @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @NotBlank
    private float pricePerDay;
    @JsonIgnoreProperties("cars")
    private AgentDTO agent;
    @JsonIgnoreProperties("car")
    private List<BookingDTO> bookings;
    
}
