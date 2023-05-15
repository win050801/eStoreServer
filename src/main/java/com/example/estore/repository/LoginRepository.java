package com.example.estore.repository;

import com.example.estore.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<User,String> {
    User findByPhoneNumber(String phone);


}
