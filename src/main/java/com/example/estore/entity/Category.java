package com.example.estore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int categoryId;
    private String name	;
    private String nameVN;


    @OneToMany(
            targetEntity = Product.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "categoryId")
    private List<Product> products = new ArrayList<>();
}
