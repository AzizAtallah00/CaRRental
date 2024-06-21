package com.example.demo.Entity;

import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking extends BaseEntity{
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    private LocalDate startDate ;
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    private LocalDate endDate ;
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    private LocalTime pickUpHour;
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    private LocalTime dropOffHour;
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    private String pickupPlace;
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    private String dropOffPlace;
    //Relations
    // @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @ManyToOne(optional = true ,  fetch = FetchType.EAGER)
    private Car car;
    @OneToOne (mappedBy = "booking", cascade= CascadeType.ALL)
    private Payment payment;
    @ManyToOne (optional = false, fetch = FetchType.EAGER)
    private Customer customer;

}
