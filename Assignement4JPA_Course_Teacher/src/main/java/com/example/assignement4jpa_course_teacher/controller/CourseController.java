package com.example.assignement4jpa_course_teacher.controller;

import com.example.assignement4jpa_course_teacher.model.dto.CourseDTO;
import com.example.assignement4jpa_course_teacher.model.entity.Course;
import com.example.assignement4jpa_course_teacher.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/getall")
    public ResponseEntity<List<CourseDTO>> getAllCourse() {
        ModelMapper mapper = new ModelMapper();
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOS = courses.stream().map(course -> mapper.map(course, CourseDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(courseDTOS);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable int id) {
        Course course = courseRepository.findById(id).orElse(null);
        CourseDTO output = new CourseDTO();
        output.setNameCourse(course.getNameCourse());
        output.setNumberOfLectures(course.getNumberOfLectures());
        return ResponseEntity.ok(output);
    }

    @PostMapping("/insertCourse")
    public ResponseEntity<String> insertCourse(@RequestBody CourseDTO input) {
        List<Course> courses = courseRepository.findAll();
        boolean flagCheck = false;
        for (Course course : courses) {
            if (input.getCode().equalsIgnoreCase(course.getCode())) {
                flagCheck = true;
                break;
            }
        }
        if (!flagCheck) {
            Course course = new Course();
            course.setNameCourse(input.getNameCourse());
            course.setNumberOfLectures(input.getNumberOfLectures());
            course.setCode(input.getCode());
            course.setCreatAt(input.getCreatAt());
            courseRepository.save(course);
            return ResponseEntity.ok("Đã thêm thành công");
        }
        return ResponseEntity.ok("Thêm thất bại. Khóa học đã tồn tại");
    }

    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable int id, @RequestBody Course dataInput) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setNameCourse(dataInput.getNameCourse());
            course.setNumberOfLectures(dataInput.getNumberOfLectures());
            course.setPrice(dataInput.getPrice());
            course.setCode(dataInput.getCode());
            course.setCreatAt(dataInput.getCreatAt());
            courseRepository.save(course);
            return ResponseEntity.ok("Khóa học đã được cập nhật");
        }
        return ResponseEntity.ok("Khóa học không tồn tại");
    }

    @DeleteMapping("/removeCourse/{id}")
    public ResponseEntity<String> removeCourse(@PathVariable int id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            courseRepository.deleteById(id);
            return ResponseEntity.ok("Khóa học đã được xóa khỏi hệ thống");
        }
        return ResponseEntity.ok("Khóa học không tồn tại");
    }

}
