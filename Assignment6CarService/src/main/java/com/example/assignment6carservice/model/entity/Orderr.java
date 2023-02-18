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
public class Orderr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "odder_id")
    private Customer customer;
    @JsonBackReference
    @OneToMany(mappedBy = "orderr")
    private Set<Staff> staffs;

    @OneToMany(mappedBy = "orderr")
    @JsonBackReference
    private Set<Product> products;

    @JsonBackReference
    @OneToMany(mappedBy = "orderr")
    private Set<Service> services;

    private String note;
    private String time_order;
    private String time_estimate;
    private String status;
    private double total_price;
}
