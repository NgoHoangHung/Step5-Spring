package com.example.assignement4jpa_course_teacher.controller;

import com.example.assignement4jpa_course_teacher.model.dto.TeacherDTO;
import com.example.assignement4jpa_course_teacher.model.entity.Course;
import com.example.assignement4jpa_course_teacher.model.entity.Teacher;
import com.example.assignement4jpa_course_teacher.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/getall")
    public ResponseEntity<List<TeacherDTO>> getAllCourse() {
        ModelMapper mapper = new ModelMapper();
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOS = teachers.stream()
                .map(teacher -> mapper.map(teacher, TeacherDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(teacherDTOS);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<TeacherDTO> getById(@PathVariable int id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        TeacherDTO output = new TeacherDTO();
        output.setNameTeacher(teacher.getNameTeacher());
        output.setEmail(teacher.getEmail());
        output.setAccountNumber(teacher.getAccountNumber());
        return ResponseEntity.ok(output);
    }

    @PostMapping("/insertTeacher")
    public ResponseEntity<String> insertTeacher(@RequestBody TeacherDTO input) {
        List<Teacher> teachers = teacherRepository.findAll();
        boolean flagCheck = false;
        for (Teacher teacher : teachers) {
            if (input.getEmail().equalsIgnoreCase(teacher.getEmail())) {
                flagCheck = true;
                return ResponseEntity.ok("Thêm thất bại. Tài khoản đã tồn tại");
            }
        }
        if (!flagCheck) {
            Teacher teacher = new Teacher();
            teacher.setNameTeacher(input.getNameTeacher());
            teacher.setEmail(input.getEmail());
            teacher.setAccountNumber(input.getAccountNumber());
            teacherRepository.save(teacher);
            return ResponseEntity.ok("Đã thêm thành công");
        }
        return ResponseEntity.ok("Thêm thất bại. Tài khoản đã tồn tại");
    }

    @PutMapping("/updateTeacherInfo/{id}")
    public ResponseEntity<String> updateTeacherInfo(@PathVariable int id, @RequestBody Teacher dataInput) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacher.setNameTeacher(dataInput.getNameTeacher());
            teacher.setEmail(dataInput.getEmail());
            teacher.setAccountNumber(dataInput.getAccountNumber());
            teacher.setIdentification(dataInput.getIdentification());
            teacher.setAvartar(dataInput.getAvartar());
            teacher.setAddress(dataInput.getAddress());
            teacherRepository.save(teacher);
            return ResponseEntity.ok("tài khoản cập nhật thành công");
        }
        return ResponseEntity.ok("Tài khoản không tồn tại");
    }

    @DeleteMapping("/removeTeacherAccount/{id}")
    public ResponseEntity<String> removeTeacherAccount(@PathVariable int id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacherRepository.deleteById(id);
            return ResponseEntity.ok(" Đã xóa thành công tài khoản giáo viên khỏi hệ thống");
        }
        return ResponseEntity.ok("tài khoản không tồn tại");
    }
}
