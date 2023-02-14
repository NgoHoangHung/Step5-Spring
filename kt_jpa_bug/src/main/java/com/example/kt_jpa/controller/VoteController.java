package com.example.kt_jpa.controller;

import com.example.kt_jpa.model.dto.VoteDTO;
import com.example.kt_jpa.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @PostMapping("")
    public ResponseEntity<String> insertVote(@RequestBody VoteDTO dto) {
        return ResponseEntity.ok(voteService.insertVote(dto));
    }
}
