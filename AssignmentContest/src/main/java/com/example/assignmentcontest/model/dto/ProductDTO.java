package com.example.assignmentcontest.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private String id;
    private String name;
    private double weight;
    private int quantity;
    private OrderrDTO orderr;


    private List<VoteDTO> voteDTO;
}
