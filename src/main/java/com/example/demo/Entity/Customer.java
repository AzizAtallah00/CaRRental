package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Customer extends User{
    @NotBlank
    @Column(nullable = false)
    private String phone ;
    //relations 
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Booking> bookings;
    
}
