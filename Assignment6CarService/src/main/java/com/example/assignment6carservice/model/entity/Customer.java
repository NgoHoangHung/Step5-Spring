package com.example.assignment6carservice.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCustomer;
    private String address;
    private String phone;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    private Set<Orderr> orders;

    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    private Set<Product> products;

}
