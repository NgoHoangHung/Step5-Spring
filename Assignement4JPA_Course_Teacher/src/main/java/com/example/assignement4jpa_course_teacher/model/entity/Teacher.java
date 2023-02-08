package com.example.assignement4jpa_course_teacher.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameTeacher;
    private String email;
    private String accountNumber;
    private String identification;
    private String avartar;
    private String address;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "teacher_student", joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;

    @JsonManagedReference
    @ManyToMany(mappedBy = "teachers")
    private Set<Course> courses;
}
