package com.example.estore.controller;

import com.example.estore.entity.Order;
import com.example.estore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @PostMapping("saveOrder")
    public Order saveOrder(@RequestBody Order order)
    {

        return orderRepository.save(order);
    }
}
