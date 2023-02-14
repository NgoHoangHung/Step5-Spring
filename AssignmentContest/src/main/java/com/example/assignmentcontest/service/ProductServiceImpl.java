package com.example.assignmentcontest.service;

import com.example.assignmentcontest.model.dto.ProductDTO;
import com.example.assignmentcontest.model.entity.Product;
import com.example.assignmentcontest.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getListProduct() {
        ModelMapper mapper = new ModelMapper();
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> mapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public Product getById(String Id) {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            if (Id.equals(product.getId())) {
                return product;
            }
        }
        return null;
    }

    public String insertProduct(ProductDTO productDTO) {
            Product input = new Product();
            input.setName(productDTO.getName());
            input.setWeight(productDTO.getWeight());
            input.setQuantity(productDTO.getQuantity());
            productRepository.save(input);
            return "Thêm sản phẩm thành công";

    }

    @Override
    public String editProduct(String id, ProductDTO productDTO) {
        if (productRepository.existsById(id)) {
            Product tmp = productRepository.findById(id).get();
            tmp.setName(productDTO.getName());
            tmp.setWeight(productDTO.getWeight());
            tmp.setQuantity(productDTO.getQuantity());
            return "Sản phẩm đã được thay đổi";
        }
        return "Sản phẩm không tồn tại";
    }

//    @Override
//    public double getPrice(ProductDTO product) {
//
//        return product.getPrice() * product.getQuantity();
//    }

    @Override
    public double getWeight(ProductDTO product) {
        return product.getWeight() * product.getQuantity();
    }

}
