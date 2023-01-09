package com.ordermanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item_name;
    private Integer quantity;
    private Long item_price;

    private Double total;

    @ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
