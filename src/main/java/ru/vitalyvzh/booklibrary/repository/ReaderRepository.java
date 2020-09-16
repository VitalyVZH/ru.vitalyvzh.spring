package ru.vitalyvzh.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vitalyvzh.booklibrary.model.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
