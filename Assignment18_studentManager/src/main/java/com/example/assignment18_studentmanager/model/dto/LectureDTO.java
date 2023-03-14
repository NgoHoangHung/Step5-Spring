package com.example.assignment18_studentmanager.model.dto;

import lombok.Data;

@Data
public class LectureDTO {
    private String title;
    private String type;
    private String author;
    private String content;
    private SubjectDTO subjectDTO;
}
