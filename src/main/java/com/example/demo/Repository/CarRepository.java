package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Car;
import com.example.demo.Enum.CarType;
import com.example.demo.Enum.FuelType;
import com.example.demo.Enum.TransmissionType;

public interface CarRepository extends JpaRepository<Car, Long>{

    Page<Car> findByModelContaining(String model, Pageable pageable);
    Page<Car> findByType (CarType type, Pageable pageable);
    Page<Car> findByCapacity (int capacity, Pageable pageable);
    Page<Car> findByTransmission (TransmissionType transmission, Pageable pageable);
    Page<Car> findByFuelType (FuelType fuelType, Pageable pageable);
    Page <Car> findByPricePerDayBetween (float min, float max, Pageable pageable);

}
