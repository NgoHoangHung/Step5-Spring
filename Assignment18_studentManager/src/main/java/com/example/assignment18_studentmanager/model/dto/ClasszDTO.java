package com.example.assignment18_studentmanager.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClasszDTO {
    private int id;
    private String name;
    private String address;
    private List<UserDTO> userDTOS;
    private List<SubjectDTO> subjectDTOS;
}
