package com.example.demo.Entity;

import java.time.LocalDateTime;

import com.example.demo.Enum.PaymentMethod;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    private long id;
    private float rentalPrice;
    private float taxAndFees ;
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    private float guaranteePrice ;
    @NotBlank
    // @Column (nullable=false)
    @NotNull
    private LocalDateTime paymentDate;
    @NotBlank
    // @Column (nullable=false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private PaymentMethod paymentMethod;
    //relations
    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    private Booking booking;

    
}
