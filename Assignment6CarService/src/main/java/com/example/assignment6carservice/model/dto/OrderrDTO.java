package com.example.assignment6carservice.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class OrderrDTO {
    private int id;
    private CustomerDTO customerDTO;
    private Set<StaffDTO> staffsDTO;
    private Set<ProductDTO> productsDTO;
    private Set<ServiceDTO> servicesDTO;
    private String note;
    private String status;
}
