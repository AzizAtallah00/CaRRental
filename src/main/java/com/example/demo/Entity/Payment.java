package com.example.demo.Entity;

import java.time.LocalDateTime;

import com.example.demo.Enum.PaymentMethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Payment  {

    @Id
    private long id;
    private float rentalPrice;
    private float taxAndFees ;
    @NotBlank
    @Column (nullable=false)
    private float guaranteePrice ;
    @NotBlank
    @Column (nullable=false)
    private LocalDateTime paymentDate;
    @NotBlank
    @Column (nullable=false)
    private PaymentMethod paymentMethod;
    //relations
    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    private Booking booking;

    
}
