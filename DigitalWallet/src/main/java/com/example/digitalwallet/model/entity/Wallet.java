package com.example.digitalwallet.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Entity
@Component
public class Wallet {
//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
//    @Column(name = "id", updatable = false, nullable = false)
//    private UUID id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    double balance;
}
