package com.example.assignment6studentmanager.service;

import com.example.assignment6studentmanager.model.dto.SubjectDTO;
import com.example.assignment6studentmanager.model.entity.Classz;
import com.example.assignment6studentmanager.model.entity.Lecture;
import com.example.assignment6studentmanager.model.entity.Subject;
import com.example.assignment6studentmanager.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubjectServiceImpl implements SubjectService {
    ModelMapper mapper = new ModelMapper();
    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public Subject findSubjectById(int id) {
        return null;
    }


    @Override
    public List<SubjectDTO> findAll() {
        return null;
    }

    @Override
    public String createSubject(SubjectDTO dto) {
        return null;
    }

    @Override
    public String updateSubject(SubjectDTO dto) {
        Subject subject = subjectRepository.findById(dto.getId()).orElse(null);
        subject.setClassz(mapper.map(dto.getClasszDTO(), Classz.class));
        subject.setLectures(dto.getLectureDTOS().stream()
                .map(lectureDTO -> mapper.map(lectureDTO, Lecture.class))
                .collect(Collectors.toSet()));
        subjectRepository.save(subject);
        return "môn học đã được cập nhật";
    }

    @Override
    public String deleteSubject(int id) {
        return null;
    }
}
