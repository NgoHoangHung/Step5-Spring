package com.example.digitalwallet.controller;

import com.example.digitalwallet.model.entity.Account;
import com.example.digitalwallet.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bank/accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("")
    public ResponseEntity<?> getAllAccount() {
        List<Account> account = accountRepository.findAllByName("nam");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(account);
    }
}
