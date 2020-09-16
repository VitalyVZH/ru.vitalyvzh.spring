package ru.vitalyvzh.booklibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vitalyvzh.booklibrary.model.Reader;
import ru.vitalyvzh.booklibrary.repository.BookRepository;
import ru.vitalyvzh.booklibrary.repository.ReaderRepository;

import java.util.List;

@RestController
public class ReaderController {

    private ReaderRepository readerRepository;
    //private BookRepository bookRepository;

    public ReaderController(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }


//    public ReaderController(ReaderRepository readerRepository, BookRepository bookRepository) {
//        this.readerRepository = readerRepository;
//        this.bookRepository = bookRepository;
//    }

    @GetMapping("/reader")
    public List<Reader> getAll() {

        return readerRepository.findAll();
    }

    @GetMapping("/generate")
    public Reader generateData(){

        Reader reader = new Reader();
        reader.setName("Viacheslav");

        return readerRepository.save(reader);
    }
}
