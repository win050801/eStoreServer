//package com.example.estore.redisentity;
//
//import lombok.*;
//import org.springframework.data.redis.core.RedisHash;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//
//@RedisHash("Products")
//@AllArgsConstructor
//@Getter
//@Setter
//@NoArgsConstructor
//@Data
//public class RProduct implements Serializable {
//
//    private int productId;
//    private String name	;
//    private double unitPrice	;
//    private String image	;
//
//    private Date productDate	;
//    private boolean available	;
//    //private int categoryId	;
//    private int quantity	;
//    private String description	;
//    private double  discount	;
//    private int viewCount	;
//    private boolean special	;
//
//
//    private List<ROrderDetails> orderDetails = new ArrayList<>();
//
//
//
//}
