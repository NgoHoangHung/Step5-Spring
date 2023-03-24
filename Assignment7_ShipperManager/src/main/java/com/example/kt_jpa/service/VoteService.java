package com.example.kt_jpa.service;

import com.example.kt_jpa.model.dto.OrderrDTO;
import com.example.kt_jpa.model.dto.VoteDTO;
import com.example.kt_jpa.model.entities.Vote;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {
    Vote getVoteById(int id);
    String insertVote(VoteDTO dto);
}
