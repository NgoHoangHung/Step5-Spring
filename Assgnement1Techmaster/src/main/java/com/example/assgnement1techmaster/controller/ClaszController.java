package com.example.assgnement1techmaster.controller;

import com.example.assgnement1techmaster.model.dto.StudentDTO;
import com.example.assgnement1techmaster.model.entity.Student;
import com.example.assgnement1techmaster.repository.ClaszRepositpory;
import com.example.assgnement1techmaster.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClaszController {
    @Autowired
    private ClaszRepositpory claszRepositpory;
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/clasz/getstudentDTO")
    public ResponseEntity<List<StudentDTO>> getAllStudentDTO() {
        ModelMapper mapper = new ModelMapper();
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = students.stream()
                .map(student -> mapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(studentDTOS);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/clasz/getstudent")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/clasz/addstudent")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDTO student) {
//        Clasz clasz = new Student();
        Student s = new Student();
        s.setNameStudent(student.getNameStudent());
        s.setAge(student.getAge());
        s.setLevel(student.getLevel());
//        s.setClasz(student.getClasz());
        studentRepository.save(s);
        return ResponseEntity.ok(s);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/clasz/edit/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,
                                                 @RequestBody StudentDTO studentInput) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setNameStudent(studentInput.getNameStudent());
            student.setAge(studentInput.getAge());
            student.setLevel(studentInput.getLevel());
            studentRepository.save(student);
            return ResponseEntity.ok(student);
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/clasz/remove/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            studentRepository.deleteById(id);
            System.out.println();
            return ResponseEntity.ok("đã xóa thành công");
        }
        return ResponseEntity.notFound().build();
    }
//    @RequestMapping(method = RequestMethod.DELETE, value = "/clasz/remove/{id}")
//    public ResponseEntity<String> removeStudent(@PathVariable int id) {
//        if (studentRepository.existsById(id)) {
//            studentRepository.deleteById(id);
//            return ResponseEntity.ok("đã xóa thành công");
//        }
//        return ResponseEntity.notFound().body("Tài khoản không tồn tại");
//    }
}
























