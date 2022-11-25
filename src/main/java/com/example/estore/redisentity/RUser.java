package com.example.estore.redisentity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("t_user")
@Getter
@Setter
public class RUser implements Serializable {
    private String phoneNumber;

    private String password;
    private String name;
    private String adrress;





}
