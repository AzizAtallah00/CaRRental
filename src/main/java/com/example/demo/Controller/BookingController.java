package com.example.demo.Controller;

import java.time.LocalDate;

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
import com.example.demo.DTO.PaymentDTO;
import com.example.demo.Service.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;
    
    @GetMapping()
    public Page<BookingDTO> getAllBookings(Pageable pageable){
        return bookingService.getAllBookings(pageable);
    }

    @GetMapping("/{id}")
    public BookingDTO getBookingById (@PathVariable long id){
        return bookingService.getById( id).get();
    }

    @GetMapping("/startDate/{startDate}")
    public Page<BookingDTO> getBookingByStartDate (@PathVariable LocalDate startDate, Pageable pageable){
        return bookingService.getByStartDate(startDate, pageable);
    }

    @GetMapping("/endDate/{endDate}")
    public Page<BookingDTO> getBookingByEndDate (@PathVariable LocalDate endDate, Pageable pageable){
        return bookingService.getByEndDate(endDate, pageable);
    }

    @DeleteMapping("/{id}") 
    public void deleteBooking(@PathVariable long id){
        bookingService.delete(id);
    }

    @PostMapping("/assignPayment/{id}")
    public BookingDTO assignPaymentToBooking (@PathVariable long id ,@RequestBody PaymentDTO payment){
        return bookingService.assignPaymentToBooking(id, payment);
    }
    

}
