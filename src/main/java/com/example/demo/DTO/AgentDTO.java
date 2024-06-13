package com.example.demo.DTO;

import java.util.List;

import com.example.demo.Entity.Car;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.validation.constraints.NotBlank;

public class AgentDTO extends UserDTO{
    
    @NotBlank
    private String phone ;
    @NotBlank
    private String agencyName;
    @NotBlank
    private String agencyAdress ;
    @JsonIgnoreProperties("agent")
    private List<Car> cars;
}
