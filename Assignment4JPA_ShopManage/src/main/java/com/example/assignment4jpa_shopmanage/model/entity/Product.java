package com.example.assignment4jpa_shopmanage.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" , strategy = "uuid2")
    private String id;
    private String nameProduct;
    private int quantity;
    private double price;
    private String description;
    @ManyToMany
    private List<Order> orderList;
}
