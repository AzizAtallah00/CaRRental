package com.example.demo.Mapper;

import org.modelmapper.ModelMapper;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.Entity.Booking;

public class BookingMapper {
    private static final ModelMapper modelMapper= new ModelMapper();

	public static BookingDTO convertToDto(Booking booking)
	{
		return modelMapper.map(booking, BookingDTO.class);
	}
	public static Booking convertToEntity(BookingDTO bookingDTO)
	{
		return modelMapper.map(bookingDTO, Booking.class);
	}
    
}
