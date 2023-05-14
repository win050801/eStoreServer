package com.example.estore.controller;


import com.example.estore.entity.Customer;
import com.example.estore.entity.User;
import com.example.estore.repository.CustomerRepository;
import com.example.estore.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    CustomerRepository repository;
//    @RequestMapping("/")
//    public String checkMVC(){
//        return "login";
//    }
@PostMapping("/register")
public Customer register(@RequestBody Customer user){
    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    repository.save(user);
    return repository.save(user);
}


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Customer user){
        Customer user1 = repository.findByEmail(user.getEmail());

        if (null == user1 || !new BCryptPasswordEncoder()
                .matches(user.getPassword(), user1.getPassword())) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account or password is not valid!");
        }


        return ResponseEntity.ok(user1);
    }










}