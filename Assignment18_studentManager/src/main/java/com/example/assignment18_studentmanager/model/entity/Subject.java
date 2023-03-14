package com.example.assignment18_studentmanager.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
