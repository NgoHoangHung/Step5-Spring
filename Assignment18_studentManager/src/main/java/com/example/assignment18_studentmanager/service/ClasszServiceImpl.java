package com.example.assignment18_studentmanager.service;

import com.example.assignment18_studentmanager.model.dto.ClasszDTO;
import com.example.assignment18_studentmanager.model.entity.Classz;
import com.example.assignment18_studentmanager.model.entity.User;
import com.example.assignment18_studentmanager.model.entity.Subject;
import com.example.assignment18_studentmanager.repository.ClasszRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClasszServiceImpl implements ClasszService {
    @Autowired
    private ClasszRepository classzRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public Classz findClassById(int id) {
        return classzRepository.findById(id).get();
    }

    @Override
    public List<ClasszDTO> findAll() {
        return classzRepository.findAll().stream()
                .map(classz -> mapper.map(classz, ClasszDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String createClassz(ClasszDTO dto) {
        List<Classz> classzs = classzRepository.findAll();
        for (Classz classz : classzs) {
            if (classz.getName().equalsIgnoreCase(dto.getName()))
                return "lớp học đã tồn tại";
        }
        Classz tmp = new Classz();
        tmp.setName(dto.getName());
        tmp.setAddress(dto.getAddress());

        tmp.setSubjects(dto.getSubjectDTOS().stream()
                .map(subjectDTO -> mapper.map(subjectDTO, Subject.class)).collect(Collectors.toList()));
        tmp.setUsers(dto.getUserDTOS().stream()
                .map(studentDTO -> mapper.map(studentDTO, User.class)).collect(Collectors.toList()));
        classzRepository.save(tmp);
        return "khởi tạo lớp học thành công";
    }

    @Override
    public String updateClassz(ClasszDTO dto) {
        return null;
    }

    @Override
    public String deleteClassz(int id) {
        return null;
    }
}
