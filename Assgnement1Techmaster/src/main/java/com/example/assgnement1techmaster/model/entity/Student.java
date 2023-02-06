package com.example.assgnement1techmaster.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameStudent;
    private Integer age;
    private String level;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "Clasz_id")
    private Clasz clasz;

//    public Student() {
//    }
//
//    public Student(String nameStudent, Integer age, String level, Clasz clasz) {
//        this.nameStudent = nameStudent;
//        this.age = age;
//        this.level = level;
//        this.clasz = clasz;
//    }

}
