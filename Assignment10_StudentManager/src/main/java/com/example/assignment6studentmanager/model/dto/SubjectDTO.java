package com.example.assignment6studentmanager.model.dto;

import com.example.assignment6studentmanager.model.entity.Classz;
import lombok.Data;

import java.util.Set;

@Data
public class SubjectDTO {
    private int id;
    private String name;
    private ClasszDTO classzDTO;
    private Set<LectureDTO> lectureDTOS;
}
