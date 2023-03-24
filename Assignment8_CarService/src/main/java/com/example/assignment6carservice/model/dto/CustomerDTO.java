package com.example.assignment6carservice.model.dto;

import com.example.assignment6carservice.model.entity.Orderr;
import com.example.assignment6carservice.model.entity.Product;
import com.example.assignment6carservice.model.entity.Wallet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Set;
@Data
public class CustomerDTO {

    private String nameCustomer;
    private String address;
    private String phone;
    private Wallet wallet;
}
