package com.example.assignmentsecurity.controller;

import com.example.assignmentsecurity.model.Product;
import com.example.assignmentsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        return ResponseEntity.ok(productRepository.findById(id).get());
    }

    @PostMapping("/products")
    public String insertProducts(@RequestBody Product product) {
        productRepository.save(product);
        return "đã thêm thành công";
    }

    @PutMapping("/updateproducts/{id}")
    public String updateProducts(@RequestBody Product productTmp, @PathVariable int id, Model model) {
        if (productRepository.existsById(id)) {
            Product product = productRepository.findById(id).get();
            product.setName(productTmp.getName());
            product.setPrice(productTmp.getPrice());
            return "đã sửa thành công";
        } else {
            String errorMessage = "Not Found Product with Id: " + id;
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
//            throw new AkioException("Not Found Product with Id: " + id);
    }


}