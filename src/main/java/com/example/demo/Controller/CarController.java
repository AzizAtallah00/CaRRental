package com.example.demo.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.DTO.CarDTO;
import com.example.demo.Enum.CarType;
import com.example.demo.Enum.FuelType;
import com.example.demo.Enum.TransmissionType;
import com.example.demo.Service.CarService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Car", description = "Car Api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @GetMapping()
    public Page<CarDTO> getAllCars(Pageable pageable){
        return carService.getAllCar(pageable);
    }
    
    @GetMapping("/{id}")
    public CarDTO getCarById (@PathVariable long id){
        return carService.getCarById( id);
    }

    @GetMapping("/model/{model}")
    public Page<CarDTO> getCarByModel (@PathVariable String model, Pageable pageable){
        return carService.getByModel(model, pageable);
    }

    @GetMapping("/type/{type}")
    public Page<CarDTO> getCarByType (@PathVariable CarType type, Pageable pageable){
        return carService.getByType(type, pageable);
    }

    @GetMapping("/capacity/{capacity}")
    public Page<CarDTO> getCarByCapacity (@PathVariable int capacity, Pageable pageable){
        return carService.getByCapacity(capacity, pageable);
    }

    @GetMapping("/transmission/{transmission}")
    public Page<CarDTO> getCarByTransmission (@PathVariable TransmissionType transmission, Pageable pageable){
        return carService.getByTransmission(transmission, pageable);
    }

    @GetMapping("/fuelType/{fuelType}")
    public Page<CarDTO> getCarByFuelType (@PathVariable FuelType fuelType, Pageable pageable){
        return carService.getByFuelType(fuelType, pageable);
    }

    @GetMapping("/pricePerDay/{min}/{max}")
    public Page<CarDTO> getCarByPricePerDayBetween (@PathVariable float min, @PathVariable float max, Pageable pageable){
        return carService.getByPricePerDayBetween(min, max, pageable);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id){
        carService.deleteCar(id);
    }

    @PostMapping("/assignBooking/{id}/{customerid}")
    public CarDTO assignBookingToCar(@PathVariable long id,@RequestBody BookingDTO booking ,@PathVariable long customerid){
        return carService.assignBookingToCar(id, booking,customerid);
    }
}
