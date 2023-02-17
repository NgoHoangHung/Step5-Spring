package com.example.assignment6studentmanager.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClasszDTO {
    private int id;
    private String name;
    private String address;
    private List<StudentDTO> studentDTOS;
    private List<SubjectDTO> subjectDTOS;
}
