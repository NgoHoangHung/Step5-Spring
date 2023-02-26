package com.example.librarymanager.repository;

import com.example.librarymanager.model.entity.Book;
import com.example.librarymanager.model.entity.BookManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookManagerRepository extends JpaRepository<BookManager, Integer> {
    @Query("SELECT b FROM BookManager bm join Book b JOIN TicketBook  t   where b.id = :id")
    List<Book> findByTicketBookId(int id);
}
