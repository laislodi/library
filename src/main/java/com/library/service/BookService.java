package com.library.service;

import com.library.persistency.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import com.library.persistency.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findById(Long idBook) {
        return bookRepository.findById(idBook);
    }

    public long save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findByGender(String gender) {
        return bookRepository.findByGender(gender);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

}
