package com.example.assignment18_studentmanager.control;

import com.example.assignment18_studentmanager.model.dto.SubjectDTO;
import com.example.assignment18_studentmanager.model.entity.Subject;
import com.example.assignment18_studentmanager.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/{id}")
    public ResponseEntity<Subject> findSubjectById(@RequestParam int id) {
        return ResponseEntity.ok(subjectService.findSubjectById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<SubjectDTO>> findAll() {
        return ResponseEntity.ok(subjectService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<String> createStudent(@RequestBody SubjectDTO dto) {
        return ResponseEntity.ok(subjectService.createSubject(dto));
    }

    @PutMapping("")
    public ResponseEntity<String> updateSubject(@RequestBody SubjectDTO dto) {
        return ResponseEntity.ok((subjectService.updateSubject(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubject(@RequestParam int id) {
        return ResponseEntity.ok(subjectService.deleteSubject(id));
    }
}
