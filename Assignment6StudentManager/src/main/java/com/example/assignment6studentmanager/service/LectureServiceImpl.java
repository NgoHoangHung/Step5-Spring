package com.example.assignment6studentmanager.service;

import com.example.assignment6studentmanager.model.dto.LectureDTO;
import com.example.assignment6studentmanager.model.entity.Lecture;
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
