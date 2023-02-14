package com.example.assignmentcontest.model.dto;

import lombok.Data;

@Data
public class VoteDTO {

    private String id;
    private double rate;
    private String message;

    private CustomerDTO customerDTO;

    private ProductDTO productDTO;
}
