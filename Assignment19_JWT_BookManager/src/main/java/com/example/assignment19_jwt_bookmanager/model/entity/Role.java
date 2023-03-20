package com.example.assignment19_jwt_bookmanager.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToMany(mappedBy = "rollSet")
    private Set<User> userSet;

    @JsonBackReference
    @OneToMany(mappedBy = "role")
    private Set<Authority> authorities;
}

