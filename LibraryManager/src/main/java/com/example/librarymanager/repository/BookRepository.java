package com.example.librarymanager.repository;

import com.example.librarymanager.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    boolean existsById(int id);

    Book findById(int id);
    List<Book> findBooksByTicketBookId(int id);
}
