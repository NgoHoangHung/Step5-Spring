package com.example.assignment4jpa_shopmanage.model.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int product_id;
    private String nameProduct;
    private int quantity;
    private double price;
}
