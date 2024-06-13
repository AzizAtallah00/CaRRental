package com.example.demo.Mapper;

import org.modelmapper.ModelMapper;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.Entity.Customer;

public class CustomerMapper {
    private static final ModelMapper modelMapper= new ModelMapper();

	public static CustomerDTO convertToDto(Customer customer)
	{
		return modelMapper.map(customer, CustomerDTO.class);
	}
	public static Customer convertToEntity(CustomerDTO customerDTO)
	{
		return modelMapper.map(customerDTO, Customer.class);
	}
    
}
