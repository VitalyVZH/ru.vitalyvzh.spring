package ru.vitalyvzh.booklibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vitalyvzh.booklibrary.model.Book;
import ru.vitalyvzh.booklibrary.repository.BookRepository;

import java.util.List;

@RestController
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book")
    public List<Book> getAll() {

        return bookRepository.findAll();
    }
}
