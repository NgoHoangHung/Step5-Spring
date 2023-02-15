package com.example.assignment4jpa_shopmanage.controller;

import com.example.assignment4jpa_shopmanage.model.entity.Shop;
import com.example.assignment4jpa_shopmanage.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("")
    public ResponseEntity<List<Shop>> getAll() {
        return ResponseEntity.ok(shopRepository.findAll());
    }
}
