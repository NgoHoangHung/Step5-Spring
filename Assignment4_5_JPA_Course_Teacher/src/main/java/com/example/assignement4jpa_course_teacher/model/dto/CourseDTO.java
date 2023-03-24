package com.example.assignement4jpa_course_teacher.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CourseDTO {
    private String nameCourse;
    private Integer numberOfLectures;
    private String code;
    private String creatAt;
}
