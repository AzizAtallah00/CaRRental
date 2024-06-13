package com.example.demo.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

public class BookingDTO extends BaseDTO {
    @NotBlank
    @FutureOrPresent
    private LocalDate startDate ;
    @NotBlank
    @FutureOrPresent
    private LocalDate endDate ;
    @NotBlank
    private LocalTime pickUpHour;
    @NotBlank
    private LocalTime dropOffHour;
    @NotBlank
    private String pickupPlace;
    @NotBlank
    private String dropOffPlace;
    @JsonIgnoreProperties("bookings")
    private CarDTO car;
    @JsonIgnoreProperties("booking")
    private PaymentDTO payment;
    @JsonIgnoreProperties("bookings")
    private CustomerDTO customer;

    
}
