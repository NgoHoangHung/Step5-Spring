package com.example.digitalwallet.controller;

import com.example.digitalwallet.model.entity.Account;
import com.example.digitalwallet.model.entity.Wallet;
import com.example.digitalwallet.repository.AccountRepository;
import com.example.digitalwallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private WalletRepository walletRepository;

    @GetMapping("/get/allaccounts")
    public ResponseEntity<?> getAllAccount() {
        List<Account> account = accountRepository.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(account);
    }

    @GetMapping("/get/allwallet")
    public ResponseEntity<?> getAllWallet() {
        List<Wallet> wallet = walletRepository.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(wallet);
    }

    @GetMapping("/get/accountbyid/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        if (accountRepository.existsById(id))
            return ResponseEntity.ok(accountRepository.getById(id));
    return null;
    }
}
