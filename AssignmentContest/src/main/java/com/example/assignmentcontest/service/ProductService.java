package com.example.assignmentcontest.service;

import com.example.assignmentcontest.model.dto.ProductDTO;
import com.example.assignmentcontest.model.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<ProductDTO> getListProduct();

    public String insertProduct(ProductDTO productDTO);

    public String editProduct(String id, ProductDTO productDTO);

//    public double getPrice(ProductDTO productDTO);

    double getWeight(ProductDTO productDTO);
}
