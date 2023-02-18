package com.example.assignment6carservice.model.dto;

import lombok.Data;

import java.util.Set;
@Data
public class CustomerDTO {
    private int id;
    private String nameCustomer;
    private String address;
    private WalletDTO walletDTO;
    private Set<OrderrDTO> orderrDTOS;
}
