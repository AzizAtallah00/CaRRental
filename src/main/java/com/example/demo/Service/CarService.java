package com.example.demo.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.DTO.CarDTO;
import com.example.demo.Enum.CarType;
import com.example.demo.Enum.FuelType;
import com.example.demo.Enum.TransmissionType;

public interface CarService {
    public Page<CarDTO> getAllCar (Pageable pageable);
    public CarDTO getCarById (long id);
    public Page<CarDTO> getByModel (String model, Pageable pageable);
    public Page<CarDTO> getByType (CarType type, Pageable pageable);
    public Page<CarDTO> getByCapacity (int capacity, Pageable pageable);
    public Page<CarDTO> getByTransmission (TransmissionType transmission, Pageable pageable);
    public Page<CarDTO> getByFuelType (FuelType fuelType, Pageable pageable);
    public Page <CarDTO> getByPricePerDayBetween (float min, float max, Pageable pageable);
    public void deleteCar (long id);
    public CarDTO assignBookingToCar (long id , BookingDTO booking , long customerid);
    
}
