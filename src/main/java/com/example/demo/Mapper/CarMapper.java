package com.example.demo.Mapper;

import org.modelmapper.ModelMapper;

import com.example.demo.DTO.CarDTO;
import com.example.demo.Entity.Car;

public class CarMapper  {
    private static final ModelMapper modelMapper= new ModelMapper();

	public static CarDTO convertToDto(Car car)
	{
		return modelMapper.map(car, CarDTO.class);
	}
	public static Car convertToEntity(CarDTO carDTO)
	{
		return modelMapper.map(carDTO, Car.class);
	}
    
}
