package com.example.assignment18_studentmanager.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class SubjectDTO {
    private int id;
    private String name;
    private ClasszDTO classzDTO;
    private Set<LectureDTO> lectureDTOS;
}
