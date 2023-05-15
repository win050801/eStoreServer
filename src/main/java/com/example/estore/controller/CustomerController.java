package com.example.estore.controller;

import com.example.estore.entity.Category;
import com.example.estore.entity.Customer;
import com.example.estore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    public CustomerRepository customerRepository;
    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }
    @PostMapping("/updateName")
    public Customer updateName(@RequestBody Customer customer)
    {
        customerRepository.save(customer);
        return customer;
    }

}
