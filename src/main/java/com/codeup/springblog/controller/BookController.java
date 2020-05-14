package com.codeup.springblog.controller;

import com.codeup.springblog.Repositories.BookRepository;
import com.codeup.springblog.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class BookController {
    // These two next steps are often called dependency injection, where we create a Repository instance and initialize it in the controller class constructor.
    private final BookRepository bookRepo;

    public BookController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/books")
    @ResponseBody
    public String getBooks() {
        String books = "<ul>";
        for (Book book : this.bookRepo.findAll()) {
            books += "<li>"+book.getTitle() + " by " + book.getDescription() + "</li>";
        }
        books += "</ul>";
        return books;
    }
    }

    // ...


