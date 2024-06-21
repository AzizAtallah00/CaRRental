package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(value = {"password"}, allowSetters = true, allowGetters = false)
public class UserDTO extends BaseDTO{

    @NotNull(message = "Email must not be null")
    private String email;
    @NotNull(message = "password must not be null")
    // @JsonIgnoreProperties(allowSetters = true, allowGetters = false)
    @NotBlank
    private String password;  
    @NotBlank
    private String roles;
    
}
