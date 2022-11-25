package com.example.estore.repository;

import com.example.estore.entity.Category;
import com.example.estore.entity.Order;
import com.example.estore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
