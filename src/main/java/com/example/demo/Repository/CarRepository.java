package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

    Page<Car> findByModel (String model, Pageable pageable);
    Page<Car> findByType (String type, Pageable pageable);
    Page<Car> findByCapacity (int capacity, Pageable pageable);
    Page<Car> findByTransmission (String transmission, Pageable pageable);
    Page<Car> findByFuelType (String fuelType, Pageable pageable);

}
