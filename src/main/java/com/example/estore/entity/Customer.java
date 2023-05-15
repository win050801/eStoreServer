package com.example.estore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customers")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
public class Customer {
    @Id
    private String customerId;
    private String password	;
    private String fullName;
    private String email;
    private String photo	;
    private boolean admin;
    private boolean activated;
    private String adress;
//    @OneToMany(mappedBy = "customer")
//    List<Order> orders;

    @OneToMany(
            targetEntity = Order.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "customerId")
    private List<Order> orders = new ArrayList<>();
    

}
