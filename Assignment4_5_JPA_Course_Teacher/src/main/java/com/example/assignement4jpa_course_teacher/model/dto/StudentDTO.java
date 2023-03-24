package com.example.assignement4jpa_course_teacher.model.dto;

import com.example.assignement4jpa_course_teacher.model.entity.Status;
import lombok.Data;

@Data
public class StudentDTO {
    private String nameStudent;
    private Status status;
    private String identification;
}
