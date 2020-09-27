package ru.vitalyvzh.booklibrary.controller;

import com.sun.tools.javac.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.vitalyvzh.booklibrary.model.Author;
import ru.vitalyvzh.booklibrary.model.Book;
import ru.vitalyvzh.booklibrary.model.Reader;
import ru.vitalyvzh.booklibrary.repository.AuthorRepository;
import ru.vitalyvzh.booklibrary.repository.BookRepository;
import ru.vitalyvzh.booklibrary.repository.ReaderRepository;

@RestController
public class ReaderController {

    private ReaderRepository readerRepository;
    private AuthorRepository authorRepository;
    //private BookRepository bookRepository;


    public ReaderController(ReaderRepository readerRepository, AuthorRepository authorRepository) {
        this.readerRepository = readerRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/reader")
    public List<Reader> getAll() {

        return (List<Reader>) readerRepository.findAll();
    }

    //возврат читателя по автору
    @GetMapping("/reader/author/{authorId}")
    public Reader getByAuthor(@PathVariable String authorId) {

        return readerRepository.findReaderByAuthorName(authorId);
    }

//    //возврат читателя по книге
//    @GetMapping("/reader/book/{bookId}")
//    public Reader getByBook(@PathVariable String bookId) {
//
//        return readerRepository.findReaderByBookName(bookId);
//    }

    @GetMapping("/generate")
    public Reader generateData(){

        Reader reader = new Reader();
        reader.setName("Vadim");

        Author author = new Author();
        author.setName("Remarque");

        authorRepository.save(author);
        author.setLibraryClient(reader);
        reader.setAuthor(List.of(author));

//        Book book = new Book();
//        book.setName("Arc_de_Triomphe");

//        bookRepository.save(book);
//        book.setLibraryClient(reader);
//        reader.setBook(List.of(book));

        return readerRepository.save(reader);
    }
}
