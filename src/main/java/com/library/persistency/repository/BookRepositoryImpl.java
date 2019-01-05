package com.library.persistency.repository;

import com.library.persistency.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        return bookList;
    }

    @Override
    public Book findById(Long idBook) {
        Book book = new Book();
        return book;
    }

    @Override
    public long save(Book book) {
        return 0;
    }

    @Override
    public List<Book> findByGender(String gender) {
        List<Book> bookList = new ArrayList<>();
        return bookList;
    }

    @Override
    public List<Book> findByTitle(String title) {
        List<Book> bookList = new ArrayList<>();
        return bookList;
    }
}
