package com.example.assignmentcontest.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private double weight;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "Orderr_id")
    private Orderr orderr;

    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private List<Vote> votes;
}
