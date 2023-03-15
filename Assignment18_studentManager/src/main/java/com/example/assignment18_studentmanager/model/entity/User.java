package com.example.assignment18_studentmanager.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

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
    private String roll;

    public User() {
    }

    public User(String name, String password, String roll) {
        this.name = name;
        this.password = password;
        this.roll = roll;
    }

    @ManyToOne
    @JoinColumn(name = "clasz_id")
    private Classz classz;
}