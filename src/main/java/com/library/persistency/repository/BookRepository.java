package com.library.persistency.repository;

import com.library.persistency.entity.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();

    Book findById(Long idBook);

    long save(Book book);

    List<Book> findByGender(String gender);

    List<Book> findByTitle(String title);
}
