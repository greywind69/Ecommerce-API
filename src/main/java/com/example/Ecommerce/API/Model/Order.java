package com.example.Ecommerce.API.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders_table")
public class Order {
    @Id
    @Column(name = "orders_id")
    private Integer ordersId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "product_quality")
    private Integer productQuantity;
}