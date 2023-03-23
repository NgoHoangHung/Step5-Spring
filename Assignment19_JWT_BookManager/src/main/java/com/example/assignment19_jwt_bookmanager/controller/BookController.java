package com.example.assignment19_jwt_bookmanager.controller;

import com.example.assignment19_jwt_bookmanager.model.entity.Book;
import com.example.assignment19_jwt_bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @GetMapping
    public String home(){
        return "index.html";
    }
    @GetMapping("/list")
    public String libManager(Model model){
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("books",bookList);
        return "list-book";
    }
}
