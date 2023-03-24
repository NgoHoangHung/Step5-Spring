package com.example.assignment4jpa_shopmanage.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameProduct;
    private int quantity;
    private double price;
    private String description;

    @ManyToMany(mappedBy = "productList")
    private List<Order> orderList;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Product(String nameProduct, int quantity, double price, String description) {
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }
}
