package com.example.demo.Entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Agent extends User{
    @NotBlank
    @NotNull
    // @Column(nullable = false )
    private String phone ;
    @NotBlank
    @NotNull
    @Column( unique = true )
    private String agencyName;
    @NotBlank
    @NotNull
    // @Column(nullable = false )
    private String agencyAddress ;
    @OneToMany(mappedBy = "agent")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Car> cars;
   
}
