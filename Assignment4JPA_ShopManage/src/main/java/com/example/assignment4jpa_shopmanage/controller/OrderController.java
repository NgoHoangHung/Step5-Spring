package com.example.assignment4jpa_shopmanage.controller;

import com.example.assignment4jpa_shopmanage.model.dto.OrderDTO;
import com.example.assignment4jpa_shopmanage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public ResponseEntity<String> createOrder(OrderDTO dto) {
        return ResponseEntity.ok(orderService.createOrder(dto));
    }
}
