package com.example.assignment6carservice.model.dto;

import com.example.assignment6carservice.model.entity.Orderr;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ServiceDTO {
    private int id;
    private String name;
    private double fee;
    private OrderrDTO orderrDTO;
}
