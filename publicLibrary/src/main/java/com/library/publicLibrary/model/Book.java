package com.library.publicLibrary.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PLmstBooks")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private boolean available;
}
