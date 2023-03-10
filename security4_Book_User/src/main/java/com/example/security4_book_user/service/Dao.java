package com.example.security4_book_user.service;

import com.example.security4_book_user.model.Book;
import com.example.security4_book_user.model.Search;

import java.io.IOException;
import java.util.List;

public abstract class Dao {
   abstract List<String[]> read();
    abstract String insert(String[] data) throws IOException;
    abstract String insert( List<String[]> data) throws IOException;

    abstract String update(Book book);

    abstract String delete(Book book);

    abstract String delete(int id);

    abstract Book search(Search keyword);

}
