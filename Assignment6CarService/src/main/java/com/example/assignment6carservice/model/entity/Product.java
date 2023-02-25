package com.example.assignment6carservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String color;
    private String status;
    private String code;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orderr orderr;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
