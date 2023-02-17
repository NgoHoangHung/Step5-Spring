package com.example.assignment6studentmanager.service;

import com.example.assignment6studentmanager.model.dto.LectureDTO;
import com.example.assignment6studentmanager.model.entity.Lecture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LectureService {
    Lecture findLectureById(int id);

    List<LectureDTO> findAll();

    String createLecture(LectureDTO dto);

    String updateLecture(LectureDTO dto);

    String deleteLecture(int id);
}
