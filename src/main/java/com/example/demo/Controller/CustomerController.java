package com.example.demo.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.Service.CustomerService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@Tag(name = "Customer", description = "Customer Api")
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public Page<CustomerDTO> getAllCustomers(Pageable pageable){
        return customerService.getAllCustomers(pageable);
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById (@PathVariable long id){
        return customerService.getCustomerById( id).get();
    }

    @PostMapping()
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customer){
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable long id){
        customerService.delete(id);
    }

    // @PostMapping("/assignBooking/{id}")
    // public CustomerDTO assignBookingToCustomer(@PathVariable long id, @RequestBody BookingDTO booking){
    //     return customerService.assignBookingToCustomer(id, booking);
    // }
    
    
}
