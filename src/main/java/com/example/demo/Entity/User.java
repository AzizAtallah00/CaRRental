package com.example.demo.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email; 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class User extends BaseEntity {

    @Email
    @NotNull
    @Column(unique = true)
    private String email;
    @NotBlank
    @NotNull
    // @Column (nullable=false)
    private String password;
    @NotBlank
    @NotNull
    private String roles;
    
}
