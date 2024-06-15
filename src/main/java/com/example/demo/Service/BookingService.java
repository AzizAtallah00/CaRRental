package com.example.demo.Service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.DTO.PaymentDTO;

public interface BookingService {
    public Page<BookingDTO> getAllBookings(Pageable pageable);
    public Optional <BookingDTO> getById(long id);
    public Page<BookingDTO> getByStartDate (LocalDate startDate, Pageable pageable);
    public Page<BookingDTO> getByEndDate (LocalDate endDate, Pageable pageable);
    public void delete(long id);
    public BookingDTO assignPaymentToBooking (long id , PaymentDTO payment);
    
}
