package com.example.digitalwallet.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    @OneToOne
    @JoinColumn(name = "MyWallet")
    private Wallet wallet;
}
