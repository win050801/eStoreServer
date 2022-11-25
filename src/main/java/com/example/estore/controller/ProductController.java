package com.example.estore.controller;

import com.example.estore.entity.Category;
import com.example.estore.entity.Product;
import com.example.estore.repository.CategoryRepository;
import com.example.estore.repository.ProductRepository;
import com.example.estore.service.CookieService;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    CookieService cookie;
    RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/getAllProduct")
    @Retry(name = "productServer",fallbackMethod = "getDefaultProductRating")
    public List<Product> getAllProduct(){
//        restTemplate.getForObject("",Product.class);
        return productRepository.findAll();
    }
    public List<Product> getDefaultProductRating( Exception ex) {
        return new ArrayList<>();
    }
    @GetMapping("product/{id}")
    public Product findCategoryById(@PathVariable int id){
        return productRepository.findById(id).get();
    }
    @GetMapping("list-by-category/{cid}")
    public List<Product> listByCategory(@PathVariable int cid){
        Category cate = categoryRepository.findById(cid).get();
        List<Product> list = cate.getProducts();
        return list;
    }
    @GetMapping("product/{name}")
    public Product findCategoryByName(@PathVariable String name){
        return productRepository.findByName(name);
    }

}
