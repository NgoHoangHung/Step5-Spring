package com.example.kt_jpa.service;

import com.example.kt_jpa.model.dto.OrderrDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderrService {
    String createOrder(OrderrDTO dto);

    String isSuccessOrder(int id);
}
