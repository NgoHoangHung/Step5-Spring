package com.example.security4_book_user.controller;

import com.example.security4_book_user.model.Book;
import com.example.security4_book_user.service.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private BookDao bookDao;

    @GetMapping
    public ResponseEntity<String> test1() {
        return ResponseEntity.ok("test1");
    }

    @GetMapping("/add")
    public ResponseEntity<String> add() {
        return ResponseEntity.ok("đã thêm thành công");
    }

    @GetMapping("/id")
    public ResponseEntity<Book> findById(@PathVariable int id) {
        return ResponseEntity.ok(bookDao.findById(id));
    }

    @GetMapping
    public ResponseEntity<String> method1() {
        return ResponseEntity.ok("đã thêm thành công");
    }

    @GetMapping
    public ResponseEntity<String> method1() {
        return ResponseEntity.ok("đã thêm thành công");
    }

    @GetMapping
    public ResponseEntity<String> method1() {
        return ResponseEntity.ok("đã thêm thành công");
    }

    @GetMapping
    public ResponseEntity<String> method1() {
        return ResponseEntity.ok("đã thêm thành công");
    }

    @GetMapping
    public ResponseEntity<String> method1() {
        return ResponseEntity.ok("đã thêm thành công");
    }
}
