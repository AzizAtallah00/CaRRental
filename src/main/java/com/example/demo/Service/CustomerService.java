package com.example.demo.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.DTO.CustomerDTO;

public interface CustomerService {
    public Page<CustomerDTO> getAllCustomers (Pageable pageable);
    public Optional<CustomerDTO> getCustomerById (long id);
    public CustomerDTO addCustomer (CustomerDTO customer);
    public void delete (long id);
    // public CustomerDTO assignBookingToCustomer (long id , BookingDTO booking);
    
}
