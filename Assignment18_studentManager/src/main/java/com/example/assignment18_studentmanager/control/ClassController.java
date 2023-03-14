package com.example.assignment18_studentmanager.control;

import com.example.assignment18_studentmanager.model.dto.ClasszDTO;
import com.example.assignment18_studentmanager.model.entity.Classz;
import com.example.assignment18_studentmanager.service.ClasszService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/classz")
public class ClassController {
    @Autowired
    private ClasszService classzService;

    @GetMapping("/{id}")
    public ResponseEntity<Classz> findClassById(@RequestParam int id) {
        return ResponseEntity.ok(classzService.findClassById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<ClasszDTO>> findAll() {
        return ResponseEntity.ok(classzService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<String> createClassz(@RequestBody ClasszDTO dto) {
        return ResponseEntity.ok(classzService.createClassz(dto));
    }

    @PutMapping("")
    public ResponseEntity<String> updateClassz(@RequestBody ClasszDTO dto) {
        return ResponseEntity.ok(classzService.updateClassz(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClassz(@RequestParam int id) {
        return ResponseEntity.ok(classzService.deleteClassz(id));
    }
}
