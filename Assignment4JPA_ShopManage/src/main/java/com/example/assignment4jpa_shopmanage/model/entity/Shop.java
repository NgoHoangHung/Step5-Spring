package com.example.assignment4jpa_shopmanage.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameShop;
    private String phone;

    @JsonBackReference
    @OneToMany(mappedBy = "shop")
    private Set<Product> products;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Shop(String nameShop, String phone) {
        this.nameShop = nameShop;
        this.phone = phone;
    }

    public Shop() {
    }
}
