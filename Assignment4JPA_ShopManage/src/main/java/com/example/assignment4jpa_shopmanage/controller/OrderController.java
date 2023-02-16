package com.example.assignment4jpa_shopmanage.controller;

import com.example.assignment4jpa_shopmanage.model.dto.OrderDTO;
import com.example.assignment4jpa_shopmanage.model.entity.Order;
import com.example.assignment4jpa_shopmanage.repository.OrderRepository;
import com.example.assignment4jpa_shopmanage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @PostMapping("")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO dto) {
        return ResponseEntity.ok(orderService.createOrder(dto));
    }
}
