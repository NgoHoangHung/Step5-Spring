package com.example.assignment6studentmanager.model.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private String name;
    private String phone;
    private String birhtday;
    private ClasszDTO classzDTO;
}
