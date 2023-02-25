package com.example.assignment6carservice.model.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private String color;
    private String status;
    private String code;
//    private OrderrDTO orderrDTO;
    private CustomerDTO customerDTO;
}
