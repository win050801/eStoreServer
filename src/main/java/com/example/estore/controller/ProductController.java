package com.example.estore.controller;

import com.example.estore.entity.Category;
import com.example.estore.entity.Product;
import com.example.estore.repository.CategoryRepository;
import com.example.estore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/getAllProduct")
    private List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    @GetMapping("product/{id}")
    private Product findCategoryById(@PathVariable int id){
        return productRepository.findById(id).get();
    }
}
