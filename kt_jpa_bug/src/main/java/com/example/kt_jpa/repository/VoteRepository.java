package com.example.kt_jpa.repository;

import com.example.kt_jpa.model.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
