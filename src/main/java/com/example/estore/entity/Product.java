package com.example.estore.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="Products")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name	;
    private double unitPrice	;
    private String image	;
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date productDate	;
    private boolean available	;
    //private int categoryId	;
    private int quantity	;
    private String description	;
    private double  discount	;
    private int viewCount	;
    private boolean special	;

    @OneToMany(
            targetEntity = OrderDetails.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "productId")
    private List<OrderDetails> orderDetails = new ArrayList<>();

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Category category;
//    @ManyToOne
//    @JoinColumn(name = "categoryId")
//    private Category category;
////
//
//    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
//
//    List<OrderDetails> orderDetails;

}
