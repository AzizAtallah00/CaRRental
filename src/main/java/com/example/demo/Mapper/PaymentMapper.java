package com.example.demo.Mapper;

import org.modelmapper.ModelMapper;

import com.example.demo.DTO.PaymentDTO;
import com.example.demo.Entity.Payment;

public class PaymentMapper {
    private static final ModelMapper modelMapper= new ModelMapper();

	public static PaymentDTO convertToDto(PaymentMapper payment)
	{
		return modelMapper.map(payment, PaymentDTO.class);
	}
	public static Payment convertToEntity(PaymentDTO paymentDTO)
	{
		return modelMapper.map(paymentDTO, Payment.class);
	}
    
}
