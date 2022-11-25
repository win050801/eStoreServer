package com.example.estore.redisentity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@RedisHash("Orders")
public class ROrder implements Serializable {


    private @Id int orderId;

    private @Indexed Date orderDate;

    private @Indexed String  address	;

    private @Indexed double amount;

    private @Indexed String description;

    private @Indexed String customerId;

    private List<ROrderDetails> orderDetails = new ArrayList<>();

}
