package com.example.assignment6carservice.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Staff")
@Setter
@Getter
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "staff_order", joinColumns = @JoinColumn(name = "orderr_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private Set<Orderr> orderrs;
}
