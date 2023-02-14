package com.example.kt_jpa.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VoteDTO {
    @NotNull
    private int order_id;
    private double rate;
    private String message;
    private ShiperDTO shiperDTO;
    private OrderrDTO orderrDTO;
}
