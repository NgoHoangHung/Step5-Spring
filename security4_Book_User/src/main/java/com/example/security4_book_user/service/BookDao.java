package com.example.security4_book_user.service;

import com.example.security4_book_user.model.Book;
import com.example.security4_book_user.model.Search;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component

public class BookDao extends Dao {


    @Override
    public List<Book> getListBook() {
        List<Book> listBook = new ArrayList<>();
        try {
            FileReader reader = new FileReader("Book.csv");
            CsvToBeanBuilder<Book> csvToBeanBuilder = new CsvToBeanBuilder<Book>(reader);
            listBook = csvToBeanBuilder.withType(Book.class).build().parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listBook;
    }


    @Override
    public Book getById(int id) {
        List<Book> listBook = new ArrayList<>();
        try {
            FileReader reader = new FileReader("Book.csv");
            CsvToBeanBuilder<Book> csvToBeanBuilder = new CsvToBeanBuilder<Book>(reader);
            listBook = csvToBeanBuilder.withType(Book.class).build().parse();
            if (listBook.size() < id) return null;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Book book : listBook) {
            if (book.getId() == id) return book;
        }
        return null;
    }

    @Override
    public String insert(Book book) {
        List<Book> listBook = new ArrayList<>();
        try {
            FileReader reader = new FileReader("Book.csv");
            CsvToBeanBuilder<Book> csvToBeanBuilder = new CsvToBeanBuilder<Book>(reader);
            listBook = csvToBeanBuilder.withType(Book.class).build().parse();
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Book book1 : listBook) {
            if (book.getTitle().equals(book1.getTitle())) return "bản ghi đã tồn tại";
        }
        book.setId(listBook.size() + 1);
        try {

            CSVWriter writer = new CSVWriter(new FileWriter("Book.csv", true));
            String[] bookInput = { String.valueOf(book.getId()), book.getTitle(), book.getDescription() };
            writer.writeNext(bookInput);
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "đã thêm thành công bản ghi";
    }

    @Override
    String insert(List<String[]> data) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("Book.csv", true));
        writer.writeAll(data);
        writer.close();
        return "đã thêm thành công một danh sách bản ghi";
    }

    @Override
    public String update(Book book) {
        return "đã chỉnh sửa thành công ";
    }

    @Override
    public String delete(Book book) {
        return "đã xóa thành công";
    }

    @Override
    public String delete(int id) {
        return "đã xóa thành công";
    }

    @Override
    Book search(Search keyword, String fileName) {
        Book book = new Book();

        return book;
    }

    public List<Book> read1() {

        List<Book> listBook = new ArrayList<>();
        try {
            FileReader reader = new FileReader("Book.csv");
            CsvToBeanBuilder<Book> csvToBeanBuilder = new CsvToBeanBuilder<Book>(reader);
            listBook = csvToBeanBuilder.withType(Book.class).build().parse();
//            if (listBook.size() < id) return null;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
//
//        for (Book book : listBook) {
//            if (book.getId() == id) return book;
//        }
        return null;
    }


}
