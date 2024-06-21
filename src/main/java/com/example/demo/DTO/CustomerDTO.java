package com.example.demo.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO extends UserDTO{
    @NotBlank
    private String phone ;
    @JsonIgnoreProperties("customer")
    private List<BookingDTO> bookings;
}
