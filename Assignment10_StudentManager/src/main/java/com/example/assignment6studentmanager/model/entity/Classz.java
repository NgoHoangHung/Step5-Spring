package com.example.assignment6studentmanager.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private List<Student> students;
    @JsonBackReference
    @OneToMany(mappedBy = "classz")
    private List<Subject> subjects;
}
