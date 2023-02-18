package com.example.assignment6carservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Setter
@Getter
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name= "staff_id")
    private Orderr orderr;
}
