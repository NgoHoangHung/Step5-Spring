package com.example.kt_jpa.controller;

import com.example.kt_jpa.model.dto.OrderrDTO;
import com.example.kt_jpa.repository.OrderrRepository;
import com.example.kt_jpa.service.OrderrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderrService orderrService;

    @PostMapping("")
    public ResponseEntity<?> createOrder(@RequestBody OrderrDTO orderrDTO) {

        return ResponseEntity.ok(orderrService.createOrder(orderrDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable int id) {

        return ResponseEntity.ok(orderrService.isSuccessOrder(id));
    }

}
