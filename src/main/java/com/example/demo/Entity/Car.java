package com.example.demo.Entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.Enum.CarType;
import com.example.demo.Enum.FuelType;
import com.example.demo.Enum.TransmissionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Car extends BaseEntity {
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    private String model;
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private CarType type;
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    private int capacity;
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private TransmissionType transmission; 
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    private float pricePerDay;
    //Relations
    @ManyToOne (optional = false , fetch = FetchType.EAGER)
    private Agent agent;
    @OneToMany(mappedBy = "car")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Booking> bookings;
    
    
}
