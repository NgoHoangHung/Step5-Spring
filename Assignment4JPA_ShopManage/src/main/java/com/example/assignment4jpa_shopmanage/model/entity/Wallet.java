package com.example.assignment4jpa_shopmanage.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(generator ="uuid")
    @GenericGenerator(name ="uuid", strategy = "uuid2")
    private String id;
    private String accountNumber;
    private Bank bank;

    private double balane;

    public Wallet() {
    }

    public Wallet(String accountNumber, Bank bank, double balane) {
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.balane = balane;
    }


}
