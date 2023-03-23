package com.example.assignment19_jwt_bookmanager.repository;

import com.example.assignment19_jwt_bookmanager.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
