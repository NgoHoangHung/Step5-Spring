package com.example.assignment4jpa_shopmanage.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@Setter
@Getter
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accountNumber;

    private double balance;

    public Wallet() {
    }

    public Wallet(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


}

