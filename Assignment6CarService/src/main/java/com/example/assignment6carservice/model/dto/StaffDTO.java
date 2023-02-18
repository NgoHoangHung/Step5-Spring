package com.example.assignment6carservice.model.dto;

import com.example.assignment6carservice.model.entity.Orderr;
import com.example.assignment6carservice.model.entity.Wallet;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class StaffDTO {
    private int id;
    private String name;
    private String phone;
    private WalletDTO wallet;

    private OrderrDTO orderrDTO;
}
