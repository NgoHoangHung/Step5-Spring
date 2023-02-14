package com.example.assignment4jpa_shopmanage.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" , strategy = "uuid2")
    private String id;
    private String name;
    private String phone;

    private String address;

    public Customer() {
    }


    public Customer(String name, String phone, String address, Wallet wallet) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.wallet = wallet;
    }

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @OneToMany
    private Set<Order> orders;
}
