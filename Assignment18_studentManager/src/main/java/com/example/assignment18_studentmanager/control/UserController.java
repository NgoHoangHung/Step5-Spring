package com.example.assignment18_studentmanager.control;

import com.example.assignment18_studentmanager.model.dto.UserDTO;
import com.example.assignment18_studentmanager.model.entity.User;
import com.example.assignment18_studentmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String findClassById(@PathVariable int id, Model model) {
        User user = userService.findClassById(id);
        model.addAttribute("user", user);
        return "userdetail";
    }

    @GetMapping("/getall")
    public String findAll(Model model) {
        List<User> listUser = userService.findAll();
        model.addAttribute("users", listUser);
        return "user.html";
    }

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @PatchMapping("")
    public ResponseEntity<String> update(@RequestBody UserDTO dto) {
        return ResponseEntity.ok((userService.updateUser(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
