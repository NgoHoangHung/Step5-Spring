package com.example.assignment4jpa_shopmanage.model.dto;

import com.example.assignment4jpa_shopmanage.model.entity.Customer;
import lombok.Data;

@Data
public class WalletDTO {
    private Integer id;
    private String accountNumber;
    private String bank;
}
