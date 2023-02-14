package com.example.kt_jpa.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class OrderrDTO {
    @NotNull
    private int shipperId;
    private CustomerDTO customer;
    @NotNull
    private String address;

    //@DateTimeFormat(fallbackPatterns = "yyyy-MM-dd hh:mm")
    private Date estimateTime;
    private Set<ProductDTO> products;
    /*private String status;
    private double price;*/
}
