package com.example.security4_book_user.service;

import com.example.security4_book_user.model.Book;
import com.example.security4_book_user.model.Search;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Service
public abstract class Dao {
//   abstract  public  void readFile(String fileName) throws FileNotFoundException;
   abstract  public  List<Book> getListBook();
   abstract  public  Book getById(int id);
    abstract String insert(String[] data) throws IOException;
    abstract String insert( List<String[]> data) throws IOException;

    abstract String update(Book book);

    abstract String delete(Book book);

    abstract String delete(int id);

    abstract Book search(Search keyword,String fileName);

}
