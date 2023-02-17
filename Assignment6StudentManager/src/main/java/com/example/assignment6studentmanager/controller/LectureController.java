package com.example.assignment6studentmanager.controller;

import com.example.assignment6studentmanager.model.dto.LectureDTO;
import com.example.assignment6studentmanager.model.entity.Lecture;
import com.example.assignment6studentmanager.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecture")
public class LectureController {
    @Autowired
    private LectureService lectureService;

    @GetMapping("/{id}")
    public ResponseEntity<Lecture> findClassById(@RequestParam int id) {
        return ResponseEntity.ok(lectureService.findLectureById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<LectureDTO>> findAll() {
        return ResponseEntity.ok(lectureService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<String> createLecture(@RequestBody LectureDTO dto) {
        return ResponseEntity.ok(lectureService.createLecture(dto));
    }

    @PutMapping("")
    public ResponseEntity<String> updateLecture(@RequestBody LectureDTO dto) {
        return ResponseEntity.ok((lectureService.updateLecture(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLecture(@RequestParam int id) {
        return ResponseEntity.ok(lectureService.deleteLecture(id));
    }
}
