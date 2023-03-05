package techmaster.assignmen_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techmaster.assignmen_security.model.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {
    @GetMapping("/products1")
    public List<Product> getProducts() {
        List<Product> result = new ArrayList();
        result.add(new Product("orange", 150));
        result.add(new Product("apple", 250));
        result.add(new Product("mango", 100));
        return result;
    }
}
