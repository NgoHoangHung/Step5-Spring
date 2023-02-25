package com.example.librarymanager.controller;

import com.example.librarymanager.model.dto.TicketBookDTO;
import com.example.librarymanager.model.entity.TicketBook;
import com.example.librarymanager.service.TicketBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketbook")
public class TicketBookController {
    @Autowired
    private TicketBookService ticketBookService;

    @GetMapping("")
    public ResponseEntity<List<TicketBook>> getAll() {
        return ResponseEntity.ok(ticketBookService.getAll1());
    }

    @PostMapping("")
    public ResponseEntity<String> rentBorrowTicket(@RequestBody TicketBookDTO dto) {
        return ResponseEntity.ok(ticketBookService.rentBook(dto));
    }
}
