package com.example.assignment6carservice.model.entity;

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
    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    @OneToMany(mappedBy = "customer")
    private Set<Orderr> orders;

}
