package com.example.assignement4jpa_course_teacher.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameStudent;
    private Status status;
    private String identification;

    private String phone;
    private String email;
    private String address;
    private String avartar;
    @JsonManagedReference
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

    @JsonManagedReference
    @ManyToMany(mappedBy = "students")
    private Set<Teacher> teachers;

}
