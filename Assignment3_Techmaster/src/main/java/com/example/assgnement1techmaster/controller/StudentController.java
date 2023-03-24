package com.example.assgnement1techmaster.controller;

import com.example.assgnement1techmaster.model.dto.StudentDTO;
import com.example.assgnement1techmaster.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
//    public List<StudentDTO> get
}
