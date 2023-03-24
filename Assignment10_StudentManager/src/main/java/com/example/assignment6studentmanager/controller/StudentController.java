package com.example.assignment6studentmanager.controller;

import com.example.assignment6studentmanager.model.dto.StudentDTO;
import com.example.assignment6studentmanager.model.entity.Student;
import com.example.assignment6studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> findClassById(@RequestParam int id) {
        return ResponseEntity.ok(studentService.findClassById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<StudentDTO>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<String> createStudent(@RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.createStudent(dto));
    }

    @PutMapping("")
    public ResponseEntity<String> updateStudent(@RequestBody StudentDTO dto) {
        return ResponseEntity.ok((studentService.updateStudent(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@RequestParam int id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }
}
