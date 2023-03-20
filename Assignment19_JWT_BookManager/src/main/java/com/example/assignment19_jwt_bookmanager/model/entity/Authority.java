package com.example.assignment19_jwt_bookmanager.model.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
@Entity
@Table

public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Override
    public String getAuthority() {
        return null;
    }
}
