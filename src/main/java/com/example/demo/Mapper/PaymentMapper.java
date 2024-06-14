package com.example.demo.Mapper;

import org.modelmapper.ModelMapper;

import com.example.demo.DTO.PaymentDTO;

public class PaymentMapper {
    private static final ModelMapper modelMapper= new ModelMapper();

	public static PaymentDTO convertToDto(PaymentMapper payment)
	{
		return modelMapper.map(payment, PaymentDTO.class);
	}
	public static PaymentMapper convertToEntity(PaymentDTO paymentDTO)
	{
		return modelMapper.map(paymentDTO, PaymentMapper.class);
	}
    
}
