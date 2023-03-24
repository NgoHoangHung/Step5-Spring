package com.example.assignment6studentmanager.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double score;
    private String phone;
    private String birhtday;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Classz classz;
}
