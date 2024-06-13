package com.example.demo.Entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Customer extends User{
    @NotBlank
    @Column(nullable = false)
    private String phone ;
    //relations 
    @OneToMany(mappedBy = "customer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Booking> bookings;
    
}
