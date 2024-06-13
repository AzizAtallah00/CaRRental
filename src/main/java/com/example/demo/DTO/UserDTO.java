package com.example.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO extends BaseDTO{
    @Email
    private String email;
    @NotBlank
    private String password;  
    @NotBlank
    private String roles;

    
}
