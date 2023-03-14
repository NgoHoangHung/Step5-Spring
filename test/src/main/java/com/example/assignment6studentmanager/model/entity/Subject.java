package com.example.assignment6studentmanager.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table
@Setter
@Getter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "classz_id")
    private Classz classz;

    @JsonBackReference
    @OneToMany(mappedBy = "subject")
    private Set<Lecture> lectures;


}
