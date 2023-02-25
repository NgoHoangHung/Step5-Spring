package com.example.librarymanager.controller;

import com.example.librarymanager.model.dto.TicketBookDTO;
import com.example.librarymanager.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrow")
public class BorrowerController {
//    @Autowired
//    private BorrowerService borrowerService;
//
//    @PostMapping("")
//    public ResponseEntity<String> insertBorrowTicket(@RequestBody TicketBookDTO dto) {
//        return ResponseEntity.ok(borrowerService.insertBorrower(dto));
//    }
}
