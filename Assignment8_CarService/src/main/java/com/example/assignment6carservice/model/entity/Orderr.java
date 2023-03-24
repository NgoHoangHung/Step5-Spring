package com.example.assignment6carservice.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
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
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToMany(mappedBy = "orderrs")
    private Set<Staff> staffs;

    @JsonBackReference
    @OneToMany(mappedBy = "orderr")
    private Set<Service> services;

    @OneToMany(mappedBy = "orderr")
    @JsonBackReference
    private Set<Product> products;

    private String note;
    private Date time_order;
    private Date time_estimate;
    private String status;
    private double total_price;
}

