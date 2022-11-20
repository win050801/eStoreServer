package com.example.estore.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private int orderId;
    //private String customerId;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date orderDate;
    private String  address	;
    private double amount;
    private String description;

//    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
//    List<OrderDetails> orderDetails;

    @OneToMany(
            targetEntity = OrderDetails.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "orderId")
    private List<OrderDetails> orderDetails = new ArrayList<>();
}
