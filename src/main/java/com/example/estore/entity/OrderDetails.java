package com.example.estore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetails")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oderDetailId;
    //private int orderId;
//    private int productId;
    private double unitPrice;
    private  int quantity;
    private double discount;
//    @ManyToOne
//    @JoinColumn(name = "orderId")
//    private Order order;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name="productId")
//
//    private Product product;

}
