package com.example.assignment4jpa_shopmanage.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "orders")
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" , strategy = "uuid2")
    private String id;
    @ManyToMany
    private List<Product> productList;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Shop shop;
    private Status status;
    private double totalPrice;

}
