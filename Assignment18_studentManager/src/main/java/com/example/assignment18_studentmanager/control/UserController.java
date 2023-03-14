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
    public ResponseEntity<User> findClassById(@RequestParam int id) {
        return ResponseEntity.ok(userService.findClassById(id));
    }

    @GetMapping("/getall")
    public String findAll(Model model) {
        List<User> listUser = userService.findAll();
        model.addAttribute("users", listUser);
        return "user.html";
    }

//    @PostMapping("/new")
//    public ResponseEntity<String> createStudent(@RequestBody UserDTO dto) {
//        return ResponseEntity.ok(userService.createUser(dto));
//    }

    @PutMapping("")
    public ResponseEntity<String> updateStudent(@RequestBody UserDTO dto) {
        return ResponseEntity.ok((userService.updateStudent(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@RequestParam int id) {
        return ResponseEntity.ok(userService.deleteStudent(id));
    }
}
