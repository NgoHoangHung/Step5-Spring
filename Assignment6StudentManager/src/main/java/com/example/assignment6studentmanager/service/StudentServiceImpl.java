package com.example.assignment6studentmanager.service;

import com.example.assignment6studentmanager.model.dto.ClasszDTO;
import com.example.assignment6studentmanager.model.dto.StudentDTO;
import com.example.assignment6studentmanager.model.entity.Classz;
import com.example.assignment6studentmanager.model.entity.Student;
import com.example.assignment6studentmanager.model.entity.Subject;
import com.example.assignment6studentmanager.repository.ClasszRepository;
import com.example.assignment6studentmanager.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClasszRepository classzRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public Student findClassById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(student -> mapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public String createStudent(StudentDTO studentDTO) {
        if (studentRepository.existsByPhone(studentDTO.getPhone()))
            return "Học sinh đã tồn tại. vui lòng thêm học sinh khác";
        Student tmp = new Student();
        tmp.setName(studentDTO.getName());
        tmp.setPhone(studentDTO.getPhone());
        tmp.setBirhtday(studentDTO.getBirhtday());
        ClasszDTO classzDTO = studentDTO.getClasszDTO();
        Classz classz;
        if (classzRepository.existsById(classzDTO.getId())) {
            classz = classzRepository.findById(classzDTO.getId()).get();
        } else {
            classz = new Classz();
            classz.setName(classzDTO.getName());
            classz.setAddress(classzDTO.getAddress());
            classz.setSubjects(classzDTO.getSubjectDTOS().stream()
                    .map(subjectDTO -> mapper.map(subjectDTO, Subject.class)).collect(Collectors.toList()));
        }
        classzRepository.save(classz);
        tmp.setClassz(classz);
        studentRepository.save(tmp);
        return "đã thêm mới một học sinh";
    }

    @Override
    public String updateStudent(StudentDTO dto) {
        return null;
    }

    @Override
    public String deleteStudent(int id) {
        if (!studentRepository.existsById(id)) return "học sinh không tồn tại";
        studentRepository.deleteById(id);
        return "đã xóa thành công";
    }
}
