package com.example.assignment6studentmanager.service;

import com.example.assignment6studentmanager.model.dto.StudentDTO;
import com.example.assignment6studentmanager.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student findClassById(int id);

    List<StudentDTO> findAll();

    String createStudent(StudentDTO dto);

    String updateStudent(StudentDTO dto);

    String deleteStudent(int id);
}
