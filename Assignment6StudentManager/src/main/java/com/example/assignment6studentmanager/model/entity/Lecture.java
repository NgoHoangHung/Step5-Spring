package com.example.assignment6studentmanager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table
@Setter
@Getter
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String type;
    private String author;
    private String content;
    @ManyToOne()
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
