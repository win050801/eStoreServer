package com.example.estore.controller;

import com.example.estore.entity.Customer;
import com.example.estore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }
}
