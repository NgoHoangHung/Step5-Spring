package com.example.security4_book_user.service;

import com.example.security4_book_user.model.Book;
import com.example.security4_book_user.model.Search;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
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
    List<String[]> read() {
        List<String[]> listBook = new ArrayList<>();
        try {
            FileReader reader = new FileReader("Book.csv");
            CSVReader csvReader = new CSVReader(reader);
            listBook = csvReader.readAll();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return listBook;
    }

    @Override
    public String insert(String[] data) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("Book.csv", true));
        writer.writeNext(data);
        writer.close();
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
    public Book search(Search keyword) {
        Book book = new Book();

        return book;
    }

    public Book findById(int id) {

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

        for (Book book : listBook) {
            if (book.getId() == id) return book;
        }
        return null;
    }


}
