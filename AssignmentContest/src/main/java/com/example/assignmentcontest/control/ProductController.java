package com.example.assignmentcontest.control;

import com.example.assignmentcontest.model.dto.ProductDTO;
import com.example.assignmentcontest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<ProductDTO> getAllProduct() {
        return productService.getListProduct();
    }

    @PostMapping("/insertProduct")
    public String insertProduct(@RequestBody ProductDTO productDTO) {
        return productService.insertProduct(productDTO);
    }

    @PutMapping("/editProduct")
    public String editProduct(@PathVariable String id, @RequestBody ProductDTO productDTO) {
        return productService.editProduct(id, productDTO);
    }

//    @GetMapping("/delete")
//    public String deleteProduct() {
//        return productService.getListProduct();
//    }
}
