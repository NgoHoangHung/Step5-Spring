package com.example.assignment18_studentmanager.service;

import com.example.assignment18_studentmanager.model.dto.LectureDTO;
import com.example.assignment18_studentmanager.model.entity.Lecture;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class LectureServiceImpl implements LectureService{
    @Override
    public Lecture findLectureById(int id) {
        return null;
    }

    @Override
    public List<LectureDTO> findAll() {
        return null;
    }

    @Override
    public String createLecture(LectureDTO dto) {
        return null;
    }

    @Override
    public String updateLecture(LectureDTO dto) {
        return null;
    }

    @Override
    public String deleteLecture(int id) {
        return null;
    }
}
