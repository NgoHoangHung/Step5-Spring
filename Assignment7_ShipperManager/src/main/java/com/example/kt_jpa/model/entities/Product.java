package com.example.kt_jpa.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class
Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double weight;
    private int quantity;
//    @JsonBackReference
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "orderr_id")
    private Orderr orderr;
}
