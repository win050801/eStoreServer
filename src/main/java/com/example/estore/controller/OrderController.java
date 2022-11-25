package com.example.estore.controller;

import com.example.estore.entity.Order;
import com.example.estore.entity.OrderDetails;
import com.example.estore.redisentity.ROrder;
import com.example.estore.redisentity.ROrderDetails;
import com.example.estore.redisrepository.OrderRedisRepository;
import com.example.estore.redisrepository.ROrderRepository;
import com.example.estore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin

public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderRedisRepository orderRedisRepository;
    @Autowired
    ROrderRepository rOrderRepository;

    @PostMapping("saveOrder")
    public Order saveOrder(@RequestBody Order order)
    {

        

//        System.out.println(orderRepository.save(order).getOrderId());
//        orderRepository.findByCustomerId(order.getCustomerId());
//        ROrder rOrder = new ROrder(order.getOrderId(),order.getAddress(),order.getAmount(),
//                order.getDescription(),order.getOrderDate(),order.getCustomerId(),null);
        List<OrderDetails> list = order.getOrderDetails();
        List<ROrderDetails> listR = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            listR.add(new ROrderDetails(list.get(i).getOderDetailId(),
                    list.get(i).getUnitPrice(),list.get(i).getQuantity(),
                    list.get(i).getDiscount(),list.get(i).getProductId()));
        }

        ROrder rOrder = new ROrder(orderRepository.save(order).getOrderId(),order.getOrderDate(),order.getAddress(),order.getAmount(),order.getDescription(),
                order.getCustomerId(),listR);
        rOrderRepository.save(rOrder);
        System.out.println(rOrderRepository.findAll());

        return orderRepository.save(order);
    }
    @PostMapping("getOrder/{id}")

    public List<Order> getOrder(@PathVariable String id)
    {
        System.out.println("1111");
        System.out.println(orderRedisRepository.findById(44));
        return orderRepository.findByCustomerId(id);
    }

}
