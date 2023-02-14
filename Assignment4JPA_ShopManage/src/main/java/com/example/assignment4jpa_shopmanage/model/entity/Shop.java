package com.example.assignment4jpa_shopmanage.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table
@Setter
@Getter
public class Shop {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" , strategy = "uuid2")
    private String id;
    private String nameShop;
    private String phone;

    @OneToMany
    private Set<Product> products;
    @OneToMany
    private Set<Order> orders;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;


}
