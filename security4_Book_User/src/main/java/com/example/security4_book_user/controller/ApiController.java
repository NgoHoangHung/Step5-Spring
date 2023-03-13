package com.example.security4_book_user.controller;

import com.example.security4_book_user.model.Book;
import com.example.security4_book_user.model.Search;
import com.example.security4_book_user.service.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private Dao bookDao;

    //    @GetMapping(value = "/username", produces = MediaType.TEXT_HTML_VALUE)
//    @ResponseBody
//    public String getUsername(Authentication authentication) {
//        String username = authentication.getName();
//        return "<h1>Tên đăng nhập: " + username + "</h1>";
//    }
    @GetMapping(value = "/userAuthen", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getUserAuthen(Authentication authentication) {
        String username = authentication.getName();
        List<String> authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return "<h1>tên đang nhập:  " + username + "</h1>" + "<p>quyền: " + authorities + "</p>";
    }

    @GetMapping("/home")
    public String home() {
        return "index.html";
    }

    @GetMapping("/getlist")
    public ResponseEntity<List<Book>> read() {
        return ResponseEntity.ok(bookDao.getListBook());
    }

    @GetMapping("/getlistbook")
    public String getList(Model model) {
        List<Book> books = bookDao.getListBook();
        model.addAttribute("books", books);
        return "listbook.html";
    }

    @GetMapping("/book/{id}")
    public String getBook(Model model, @PathVariable int id) {
        Book book = bookDao.getById(id);
        model.addAttribute("book", book);
        return "bookcard.html";
    }
//    return ResponseEntity.ok(bookDao.getById(id));

    @GetMapping("/add")
    public ResponseEntity<String> add() {
        return ResponseEntity.ok("đã thêm thành công");
    }

//    @GetMapping("/id")
//    public ResponseEntity<Book> findById(@PathVariable int id) {
//        return ResponseEntity.ok(bookDao.findById(id));
//    }

    @PostMapping("/save")
    public ResponseEntity<String> insert() {
        return ResponseEntity.ok("đã thêm thành công");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return ResponseEntity.ok("xóa thành công");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> edit() {
        return ResponseEntity.ok("đã sửa thành công");
    }

    @GetMapping("/search")
    public ResponseEntity<String> search(Search keyword) {
        return ResponseEntity.ok("xem qua tí");
    }

    @PostMapping("/search")
    public ResponseEntity<String> method1() {
        return ResponseEntity.ok("đã thêm thành công");
    }
}
