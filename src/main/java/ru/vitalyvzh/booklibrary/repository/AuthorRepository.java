package ru.vitalyvzh.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vitalyvzh.booklibrary.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
