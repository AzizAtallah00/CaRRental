package com.example.demo.Service.Impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.DTO.PaymentDTO;
import com.example.demo.Entity.Booking;
import com.example.demo.Entity.Payment;
import com.example.demo.Mapper.BookingMapper;
import com.example.demo.Mapper.PaymentMapper;
import com.example.demo.Repository.BookingRepository;
import com.example.demo.Repository.PaymentRepository;
import com.example.demo.Service.BookingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public Page<BookingDTO> getAllBookings (Pageable pageable) {
        Page < Booking> bookings = bookingRepository.findAll(pageable);
        return bookings.map (BookingMapper::convertToDto);
    }

    @Override
    public Optional <BookingDTO> getById(long id) {
        Optional < Booking> booking = bookingRepository.findById(id);
        return booking.map(BookingMapper::convertToDto);
    }

    @Override
    public Page<BookingDTO> getByStartDate(LocalDate startDate, Pageable pageable) {
        Page<Booking> bookings = bookingRepository.findByStartDate(startDate, pageable);
        return bookings.map(BookingMapper::convertToDto);
    }

    @Override
    public Page<BookingDTO> getByEndDate(LocalDate endDate, Pageable pageable) {
        Page<Booking> bookings = bookingRepository.findByEndDate(endDate, pageable);
        return bookings.map(BookingMapper::convertToDto);
    }


    @Override
    public void delete(long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public BookingDTO assignPaymentToBooking(long id, PaymentDTO payment) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking == null) return null;
        else{
            Payment paymentEntity = PaymentMapper.convertToEntity(payment);
            paymentEntity.setBooking(booking);
            paymentRepository.save(paymentEntity);
            booking.setPayment(paymentEntity);
            bookingRepository.save(booking);
            return BookingMapper.convertToDto(booking);
        }

    }

}
