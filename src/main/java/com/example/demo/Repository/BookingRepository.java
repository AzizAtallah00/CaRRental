package com.example.demo.Repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    Page < Booking> findAll(Pageable pageable); 
    Page < Booking> findByStartDate(LocalDate startDate, Pageable pageable);
    Page < Booking> findByEndDate(LocalDate endDate, Pageable pageable);
}
