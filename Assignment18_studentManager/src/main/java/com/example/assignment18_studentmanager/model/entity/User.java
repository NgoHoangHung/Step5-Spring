package com.example.assignment18_studentmanager.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private double score;
    private String phone;

//    @Enumerated(EnumType.STRING)
//    private Authority authority;
    @ManyToOne
    @JoinColumn(name = "clasz_id")
    private Classz classz;
}