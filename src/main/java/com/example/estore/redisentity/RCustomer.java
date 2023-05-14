//package com.example.estore.redisentity;
//
//import lombok.*;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.redis.core.RedisHash;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@RedisHash("Customers")
//@AllArgsConstructor
//@Getter
//@Setter
//@NoArgsConstructor
//@Data
//public class RCustomer implements Serializable {
//    @Id
//    private String customerId;
//    private String password	;
//    private String fullName;
//    private String email;
//    private String photo	;
//    private boolean admin;
//    private boolean activated;
//
//    private List<ROrder> orders = new ArrayList<>();
//
//}
