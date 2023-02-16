package com.example.assignment4jpa_shopmanage.model.dto;

import com.example.assignment4jpa_shopmanage.model.entity.Customer;
import com.example.assignment4jpa_shopmanage.model.entity.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;
@Data
public class OrderDTO {
//    private int order_id;
    private List<ProductDTO> productList;
    private CustomerDTO customerDTO;
    private String status;
    private double totalPrice;
}
