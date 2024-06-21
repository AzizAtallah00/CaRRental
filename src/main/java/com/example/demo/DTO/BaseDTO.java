package com.example.demo.DTO;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class BaseDTO {
    @Id
    private Long id;
    private String createdAt;
    private String updatedAt;
    
}
