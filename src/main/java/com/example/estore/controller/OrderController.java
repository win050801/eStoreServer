package com.example.estore.controller;

import com.example.estore.entity.Order;
import com.example.estore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("getOrder/{id}")
    public List<Order> getOrder(@PathVariable String id)
    {
        return orderRepository.findByCustomerId(id);
    }

    @PostMapping("getOrder/{name}")
    public List<Order> getOrderName(@PathVariable String name)
    {
        return orderRepository.findByCustomerName(name);
    }

}
