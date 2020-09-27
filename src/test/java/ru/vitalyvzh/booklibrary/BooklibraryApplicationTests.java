package ru.vitalyvzh.booklibrary;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vitalyvzh.booklibrary.model.Author;
import ru.vitalyvzh.booklibrary.model.Book;
import ru.vitalyvzh.booklibrary.repository.AuthorRepository;
import ru.vitalyvzh.booklibrary.repository.BookRepository;

import java.util.List;

@SpringBootTest
@DisplayName("Проверка работоспособности библиотеки")
class BooklibraryApplicationTests {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Test
    @DisplayName("Проверка количества книг")
    void countBooks() {
        List<Book> all = bookRepository.findAll();
        Assertions.assertThat(all).size().isEqualTo(2);
    }

    @Test
    @DisplayName("Проверка количества авторов")
    void countAuthors() {
        List<Author> all = authorRepository.findAll();
        Assertions.assertThat(all).size().isEqualTo(1);
    }

    @Test
    @DisplayName("Проверка наличия конкретного автора")
    void findSpecificAuthor() {
        List<Author> all = authorRepository.findAll();
        Assertions.assertThat(all).toString().contains("Remarque");
    }
}
