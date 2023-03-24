package com.example.demo1.controller;

import com.example.demo1.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("lê", 100));
        products.add(new Product("táo", 120));
        products.add(new Product("bưởi", 130));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/test1")
    public String test1() {
        System.out.println("             /|      ___\n" +
                "            // \\   ,'   `.\n" +
                "           ||  o\\_/ o  .-. \\\n" +
                "           \\_  _      /  ,  \\\n" +
                "            /`    \\   `-'   /\n" +
                "           /       )-._ `._.'\n" +
                "          /      ,'      `.\n" +
                "          /     ,'          `.\n" +
                "         (      /             \\\n" +
                "          `----'               \\\n" +
                "                                `\\\n" +
                "                                `-`\n");
        return "test";
    }

    @GetMapping("/test2")
    public String test2() {
        System.out.println("████████████████████████████████████████████████████████████████████████████████\n" +
                "    ████████████████████████████████████████████████████████████████████████████████\n" +
                "    ████████████████████████████████████████████████████████████████████████████████\n" +
                "    ████████████████████████████████████████████████████████████████████████████████\n" +
                "    █████████████████████████████████████████████▓██████████████████████████████████\n" +
                "    ██████████████████████████████████████████▓█████████████████████████████████████\n" +
                "    ████████████████████████████████████████████▓▓██████████████████████████████████\n" +
                "    █████████████████████████████████████████████████▓██████████████████████████████\n" +
                "    ████████████████████████████████████████████████████████████████████████████████\n" +
                "    ███████████████████████████████▓████████████████████████████████████████████████\n" +
                "    ████████████████████████████████████████████████████████████████████████████████\n" +
                "    ██████████████████████████████████▓█████████▓█████▓█████████████████████████████\n" +
                "    █████████████████████████▓████▓▓▓▓╣╫▓▓▓▓▓▓▓╜▒▒╢▓█▓██████████████████████████████\n" +
                "    ████████████████████████▓▓▓▓▓▓▓▓▓▓▒▒▒╫╣╣▒▒▒▒▒▒╢▓▓▓██████████████████████████████\n" +
                "    █████████████████████████▓▓▓▓▓▓▓▓▓▓@▒▒▒▓▓▓▓▓▓▓▓▓▓@░░▀███████████████████████████\n" +
                "    ███████████████████████████▓▓▓▓████████▓▓▓▓▓▓▓▓▓╫▒▒▒ ░██████████████████████████\n" +
                "    ███████████████████████████▓▓▓▓█████▓████▓▓▓▓▓▓▓▒░▒░▒░██████████████████████████\n" +
                "    ████████████████████████████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▒░░░░╓██████████▌ ▀▀████████████\n" +
                "    ███████████▓██████████████████▓▓▓▓▓▓▓▓╢╢╢▓▓███▓▓▒▒░░░▐██████████▌    ╙██████████\n" +
                "    ████████▀▒▒▓███████████████████▓▓▓▓▓╣▒▓▓▓█████▓▒▒░░▒░███████████▌░  ░░▒█████████\n" +
                "    ██████▒▒▒▒▒╫████████▌▓████████████████████████▓▒▒▒░░▐███████████░░░░▒▒▒▒████████\n" +
                "    █████▓▓╫╬╣╣╣████████▓╣▓██████████████████████▓▓▓@m╖▒▒██████████▌▒▒▒▒▒▒▒╢████████\n" +
                "    █████▓▓▓╢▓╣▓╫███████▓╣╢▓████████████████████▓▒▒░░░▒▒▒██████████▒▒▒▒▒▒╢╢╢▒███████\n" +
                "    █████▓▓▓▓▓▓▓▓╫█████▌╣╣╢╣▓▓█████████████████▓▒▒╖µµ@@▒▒██████████╢╣╢▒▒╣▒╢╢╫███████\n" +
                "    █████▓▓▓▓▓▓▓▓▓█████╣╣╢╢╣╢▓████████████████████▄▄▒▓▓▓██████████▌╫╣▒╣▒▒╢╣▒▓███████\n" +
                "    █████▓▓▓▓▓▓▓▓▓▓████▓▓▓╣╢▓▓▓▓██████████████▓██████▓▓▓██████████▓╫▓╢▓▒▓▓╫▒▓███████\n" +
                "    ██████▓▓▓▓▓▓▓▓▓█████████████████████████▓▓▓▓██▓██▓▓▓██████████▓▓▓▓▒▓▓▓▒▓▓███████\n" +
                "    ██████▓▓▓▓▓▓▓▓▓▓████████▓▓▓▓█▓██████████▓▓▓█▓▓▓█▓▓▓▓██████████▓▓▓▓▓▓▒▓▓▓▓███████\n" +
                "    ███████▓▓▓▓▓▓▓▓▓▓███████▓▓▓▓▓▓▓▓▓████████▓▓▓▓╢╢╣╢╣╣╢█████████▓▓▓▓╣▒▓▓▓▓╣╣███████\n" +
                "    ███████▓▓▓▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓╣▓▓▓▓▓╣███████▓▓╢╫▓▓▒╢▓▓▒▓▒███████\n" +
                "    ███████▓▓▓▓▓▓▓▓▓▓▓█████▓▓▓▓▓▓▓▓▓▓▓█████▓▓▓▓▓▓▓▓▓▓▓▓▓▓╫█████▓╣╢╢▒▒▒▒▒╣▒╣▒▒███████\n" +
                "    ███████▓▓▓▓▓▓▓▓▓▓▓▓█████▓▓▓▓▓▓▓▓▓▓████▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓╣╢╢╢▒╢╢╣▓▓▒╫▓▐███████\n" +
                "    ████████▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓╢╢╢╣╢╢╬▓▒╬@▒╣ä▓███████\n" +
                "    ████████▓▓▓▓▓▓▓▓▓▓▓▓▓▓███▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓▓▓▒▒▒▒╢╜▒╢▒╫▓Ñ╟▓███████\n" +
                "    ████████▓▓▓▓▓▓▓▓▓▓▓▓▓▓███▓▓▓▓▓▓▓▓▓▓███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓╬▓╬╣▒╫▒╫╬▒▓╜╓╣╢╢███████\n" +
                "    █████████▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓╫▓▓▓▓▓▓▓██▓▓╣▒▒▒▒▒▒▒╓p╬╣╫╣▓███████\n" +
                "    ");
        return "test2";
    }

    @GetMapping("/test3")
    public String test3() {
        return "test3";
    }

    @GetMapping("/index")
    public String test4() {
        return "index.html";
    }

}
