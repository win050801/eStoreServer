package com.example.estore.repository;

import com.example.estore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByCustomerId(String id);

}
