package com.example.demo.Service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.DTO.CarDTO;
import com.example.demo.Entity.Booking;
import com.example.demo.Entity.Car;
import com.example.demo.Entity.Customer;
import com.example.demo.Enum.CarType;
import com.example.demo.Enum.FuelType;
import com.example.demo.Enum.TransmissionType;
import com.example.demo.Mapper.BookingMapper;
import com.example.demo.Mapper.CarMapper;
import com.example.demo.Repository.BookingRepository;
import com.example.demo.Repository.CarRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Service.CarService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{
  
    private final CarRepository carRepository;
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;

    @Override
    public Page<CarDTO> getByModel(String model, Pageable pageable) {
        Page <Car> cars = carRepository.findByModelContaining(model, pageable);
        return cars.map(CarMapper::convertToDto);
    }

    @Override
    public Page<CarDTO> getByType(CarType type, Pageable pageable) {
        Page <Car> cars = carRepository.findByType(type, pageable);
        return cars.map(CarMapper::convertToDto);
    }

    @Override
    public Page<CarDTO> getByCapacity(int capacity, Pageable pageable) {
        Page <Car> cars = carRepository.findByCapacity(capacity, pageable);
        return cars.map(CarMapper::convertToDto);
    }

    @Override
    public Page<CarDTO> getByTransmission(TransmissionType transmission, Pageable pageable) {
        Page <Car> cars = carRepository.findByTransmission(transmission, pageable);
        return cars.map(CarMapper::convertToDto);
    }

    @Override
    public Page<CarDTO> getByFuelType(FuelType fuelType, Pageable pageable) {
        Page <Car> cars = carRepository.findByFuelType(fuelType, pageable);
        return cars.map(CarMapper::convertToDto);
    }

    @Override
    public Page<CarDTO> getByPricePerDayBetween(float min, float max, Pageable pageable) {
        Page <Car> cars = carRepository.findByPricePerDayBetween(min, max, pageable);
        return cars.map(CarMapper::convertToDto);
    }

    @Override
    public Page<CarDTO> getAllCar(Pageable pageable) {
        Page<Car> cars = carRepository.findAll(pageable);
        return cars.map(CarMapper::convertToDto);
    }

    @Override
    public CarDTO getCarById(long id) {
        Car car = carRepository.findById(id).get();
        return CarMapper.convertToDto(car);
    }

    @Override
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarDTO assignBookingToCar(long id, BookingDTO booking , long customerid) {
        Car car = carRepository.findById(id).get();
        Customer customer = customerRepository.findById(customerid).get();
        Booking booking1 = BookingMapper.convertToEntity(booking);
        booking1.setCar(car);
        booking1.setCustomer(customer);
        bookingRepository.save (booking1);
        return CarMapper.convertToDto(car);
    }
    
}
