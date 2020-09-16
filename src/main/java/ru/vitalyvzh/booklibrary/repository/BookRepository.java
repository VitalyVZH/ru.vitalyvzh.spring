package ru.vitalyvzh.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vitalyvzh.booklibrary.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
