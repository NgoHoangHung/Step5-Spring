package com.example.assignment6carservice.service;

import com.example.assignment6carservice.model.dto.OrderrDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderrService {
    String insertOrder(OrderrDTO dto);
}
