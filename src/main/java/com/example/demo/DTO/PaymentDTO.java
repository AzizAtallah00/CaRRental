package com.example.demo.DTO;

import java.time.LocalDateTime;

import com.example.demo.Enum.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
    
    @Positive
    private float rentalPrice;
    @Positive
    private float taxAndFees ;
    @NotBlank
    @Positive
    private float guaranteePrice ;
    @NotBlank
    @FutureOrPresent
    private LocalDateTime paymentDate;
    @NotBlank
    private PaymentMethod paymentMethod;
    @JsonIgnoreProperties("payment")
    private BookingDTO booking;
    
}
