package com.example.assignmentsecurity.controller;

import com.example.assignmentsecurity.model.Product;
import com.example.assignmentsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/user")
    public String response1() {
        return "user";
    }

    @GetMapping("/admin")
    public String response2() {
        return "admin";
    }

    @GetMapping("/operator")
    public String response3() {
        return "operator";
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        return ResponseEntity.ok(productRepository.findById(id).get());
    }

    @PostMapping("/products")
    public String insertProducts(@RequestBody Product product) {
        productRepository.save(product);
        return "???? th??m th??nh c??ng";
    }

    @PutMapping("/updateproducts/{id}")
    public String updateProducts(@RequestBody Product productTmp, @PathVariable int id, Model model) {
        if (productRepository.existsById(id)) {
            Product product = productRepository.findById(id).get();
            product.setName(productTmp.getName());
            product.setPrice(productTmp.getPrice());
            return "???? s???a th??nh c??ng";
        } else {
            String errorMessage = "Not Found Product with Id: " + id;
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
//            throw new AkioException("Not Found Product with Id: " + id);
    }

    @GetMapping("/logincustom")
    public String getLoginPage() {
        return "logincustom";
    }

    @PostMapping("/login")
    public String request(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // S??? d???ng AuthenticationManager ????? x??c th???c ng?????i d??ng
        AuthenticationManager authenticationManager = new ProviderManager(Arrays.asList(authenticationProvider));
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authRequest);

        // ?????t ?????i t?????ng Authentication v??o SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // L???y URL ???????c y??u c???u ban ?????u v?? chuy???n h?????ng ng?????i d??ng ?????n ????
        SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
        if (savedRequest != null) {
            return "redirect:" + savedRequest.getRedirectUrl();
        } else {
            return "redirect:/forbidenerror";
        }
    }


    @GetMapping("/un-authorizes")
    public ResponseEntity<String> unAuthorizes() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("forbidenerror");
    }
//    return ResponseEntity.ok()

}