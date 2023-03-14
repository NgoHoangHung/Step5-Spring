package com.example.assignment18_studentmanager.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Classz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    @JsonBackReference
    @OneToMany(mappedBy = "classz")
    private List<User> users;
    @JsonBackReference
    @OneToMany(mappedBy = "classz")
    private List<Subject> subjects;
}
