package ru.vitalyvzh.booklibrary.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JsonBackReference
    private Reader libraryClient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reader getLibraryClient() {
        return libraryClient;
    }

    public void setLibraryClient(Reader libraryClient) {
        this.libraryClient = libraryClient;
    }
}
