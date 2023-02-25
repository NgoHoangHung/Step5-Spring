package com.example.librarymanager.service;

import com.example.librarymanager.model.dto.BorrowerDTO;
import com.example.librarymanager.model.dto.TicketBookDTO;
import com.example.librarymanager.model.entity.Borrower;
import com.example.librarymanager.model.entity.TicketBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowerService {
    public Borrower getById(int id);
    public List<Borrower> getAll();
    public Borrower creatBorrower(BorrowerDTO dto);
    public String updateBorrower(BorrowerDTO dto);
    public String deleteBorrower(int id);
}
