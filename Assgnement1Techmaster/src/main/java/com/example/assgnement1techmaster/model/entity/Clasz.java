package com.example.assgnement1techmaster.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Clasz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    @JsonBackReference
    @OneToMany(mappedBy = "clasz")
    private Set<Student> students;
}
