package com.example.assignment4jpa_shopmanage.service;

import com.example.assignment4jpa_shopmanage.model.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
     String createOrder(OrderDTO dto);
}
