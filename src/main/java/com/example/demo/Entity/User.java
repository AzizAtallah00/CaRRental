package com.example.demo.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email; 
import jakarta.validation.constraints.NotBlank;

@MappedSuperclass
public class User extends BaseEntity {

    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @NotBlank
    @Column (nullable=false)
    private String password;
    @NotBlank
    private String roles;
    
}
