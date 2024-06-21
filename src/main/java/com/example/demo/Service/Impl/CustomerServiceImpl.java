package com.example.demo.Service.Impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.Entity.Customer;
import com.example.demo.Mapper.CustomerMapper;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;


    @Override
    public Page<CustomerDTO> getAllCustomers(Pageable pageable) {
        Page <Customer> customers = customerRepository.findAll(pageable);
        return customers.map(CustomerMapper:: convertToDto);
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(long id) {
        Optional <Customer> customer = customerRepository.findById(id);
        return customer.map(CustomerMapper:: convertToDto);
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customer) {
        if (customer.getEmail()=="")
        throw new IllegalArgumentException("Email must not be empty");
        if (customer.getPassword()=="")
        throw new IllegalArgumentException("Password must not be empty");
        return CustomerMapper.convertToDto(customerRepository.save (CustomerMapper.convertToEntity(customer)));
    }

    @Override
    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    // @Override
    // public CustomerDTO assignBookingToCustomer(long id, BookingDTO booking) {
    //     Customer customer  = customerRepository.findById (id).orElse(null);
    //     if (customer == null) return null;
    //     else{
    //         Booking bookingEntity = BookingMapper.convertToEntity(booking);
    //         bookingEntity.setCustomer(customer);
    //         bookingRepository.save(bookingEntity);
    //         return CustomerMapper.convertToDto(customer);
    //     }
    // }
    
}
