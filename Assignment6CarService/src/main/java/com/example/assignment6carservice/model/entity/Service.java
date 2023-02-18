package com.example.assignment6carservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double fee;
    @ManyToOne
    @JoinColumn(name= "service_id")
    private Orderr orderr;
}
