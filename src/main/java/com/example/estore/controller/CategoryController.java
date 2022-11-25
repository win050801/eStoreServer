    package com.example.estore.controller;

import com.example.estore.entity.Category;
import com.example.estore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    public CategoryRepository categoryRepository;
    @GetMapping("/getAllCategories")
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    @GetMapping("categories/{id}")
    public Category findCategoryById(@PathVariable int id){
        return categoryRepository.findById(id).get();
    }

}
