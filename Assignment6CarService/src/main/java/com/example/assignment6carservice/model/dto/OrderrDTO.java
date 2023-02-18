package com.example.assignment6carservice.model.dto;

import com.example.assignment6carservice.model.entity.Customer;
import com.example.assignment6carservice.model.entity.Product;
import com.example.assignment6carservice.model.entity.Service;
import com.example.assignment6carservice.model.entity.Staff;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;
@Data
public class OrderrDTO {
    private int id;
    private CustomerDTO customerDTO;
    private Set<StaffDTO> staffsDTO;
    private Set<ProductDTO> productsDTO;
    private Set<ServiceDTO> serviceDTOS;
    private String note;
    private String status;
    private double total_price;
}
