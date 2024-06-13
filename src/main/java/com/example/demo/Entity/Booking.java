package com.example.demo.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Booking extends BaseEntity{
    @NotBlank
    @Column (nullable=false)
    private LocalDate startDate ;
    @NotBlank
    @Column (nullable=false)
    private LocalDate endDate ;
    @NotBlank
    @Column (nullable=false)
    private LocalTime pickUpHour;
    @NotBlank
    @Column (nullable=false)
    private LocalTime dropOffHour;
    @NotBlank
    @Column (nullable=false)
    private String pickupPlace;
    //Relations
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Car car;
    @OneToOne (mappedBy = "booking", cascade= CascadeType.ALL)
    private Payment payment;
    @ManyToOne (optional = false, fetch = FetchType.EAGER)
    private Customer customer;

}
