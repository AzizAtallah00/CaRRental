package com.example.demo.DTO;

import java.util.List;

import com.example.demo.Entity.Car;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentDTO extends UserDTO{
    
    @NotBlank
    @NotNull
    private String phone ;
    @NotBlank
    @NotNull
    private String agencyName;
    @NotBlank
    @NotNull
    private String agencyAddress ;
    @JsonIgnoreProperties("agent")
    private List<CarDTO> cars;
}
