package com.example.assignmentcontest.repository;

import com.example.assignmentcontest.model.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,String> {
}
