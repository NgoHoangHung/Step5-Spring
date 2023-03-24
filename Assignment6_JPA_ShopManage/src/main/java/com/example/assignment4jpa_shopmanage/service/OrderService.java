package com.example.assignment4jpa_shopmanage.service;

import com.example.assignment4jpa_shopmanage.model.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<OrderDTO> getAllOrder();

    String createOrder(OrderDTO dto);
}
