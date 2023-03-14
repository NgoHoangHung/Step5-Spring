package com.example.assignment6studentmanager.model.dto;

import com.example.assignment6studentmanager.model.entity.Subject;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class LectureDTO {
    private String title;
    private String type;
    private String author;
    private String content;
    private SubjectDTO subjectDTO;
}
