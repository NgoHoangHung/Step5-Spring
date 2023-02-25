package com.example.assignment6carservice.controller;

import com.example.assignment6carservice.model.dto.OrderrDTO;
import com.example.assignment6carservice.service.OrderrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderr")
public class OrderrController {
    @Autowired
    private OrderrService orderrService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderrDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(orderrService.getById(id));
    }

    @GetMapping("")
    private ResponseEntity<List<OrderrDTO>> getAll() {
        return ResponseEntity.ok(orderrService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<String> insertOrder(@RequestBody OrderrDTO dto) {
        return ResponseEntity.ok(orderrService.insertOrder(dto));
    }
    private ResponseEntity<String> updateOrderr(@RequestBody OrderrDTO dto) {
        return ResponseEntity.ok(orderrService.updateOrderr(dto));
    }

}
