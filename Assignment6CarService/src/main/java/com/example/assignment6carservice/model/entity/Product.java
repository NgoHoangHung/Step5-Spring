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
    @ManyToOne
    @JoinColumn(name= "product_id")
    private Orderr orderr;
}
