package ru.vitalyvzh.booklibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vitalyvzh.booklibrary.model.Author;
import ru.vitalyvzh.booklibrary.repository.AuthorRepository;

import java.util.List;

@RestController
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/author")
    public java.util.List<Author> getAll() {

        return authorRepository.findAll();
    }
}
