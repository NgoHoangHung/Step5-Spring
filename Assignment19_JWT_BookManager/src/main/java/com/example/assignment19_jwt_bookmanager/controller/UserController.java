//package com.example.assignment19_jwt_bookmanager.controller;
//
//import com.example.assignment19_jwt_bookmanager.payload.request.LoginRequest;
//import com.example.assignment19_jwt_bookmanager.payload.response.LoginResponse;
//import com.example.assignment19_jwt_bookmanager.security.jwt.JwtUtils;
//import com.example.assignment19_jwt_bookmanager.security.service.UserDetailsImpl;
//import com.example.assignment19_jwt_bookmanager.security.service.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private JwtUtils jwtUtils;
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//        // Xác thực từ username và password.
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
//
//        // Nếu không xảy ra exception tức là thông tin hợp lệ
//        // Set thông tin authentication vào Security Context
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Trả về jwt cho người dùng.
//        final String jwt = jwtUtils.genarateToken((UserDetailsImpl) userDetails);
//        return ResponseEntity.ok(new LoginResponse(jwt,3600000L));
//    }
//
//    @PostMapping("/register")
//    public String test2() {
//        return "test2";
//    }
//
//    @GetMapping("/test3")
//    public String test3() {
//        return "test3";
//    }
//}
