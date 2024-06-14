package com.example.demo.Entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Agent extends User{
    @NotBlank
    @Column(nullable = false )
    private String phone ;
    @NotBlank
    @Column(nullable = false , unique = true)
    private String agencyName;
    @NotBlank
    @Column(nullable = false)
    private String agencyAddress ;
    @OneToMany(mappedBy = "agent")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Car> cars;
   
}
