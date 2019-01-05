package com.library.controller;

import com.library.persistency.entity.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/find")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @RequestMapping(value = "/find-gender")
    public List<Book> findByGender(@RequestParam(value = "gender") String gender) {
        return bookService.findByGender(gender);
    }
}
