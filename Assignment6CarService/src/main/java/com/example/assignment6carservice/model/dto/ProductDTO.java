package com.example.assignment6carservice.model.dto;

import com.example.assignment6carservice.model.entity.Orderr;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private String color;
    private String status;
    private OrderrDTO orderrDTO;
}
