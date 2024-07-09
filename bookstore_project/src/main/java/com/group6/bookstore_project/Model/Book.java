package com.brandon.bookSearch.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookID;
    private String isbn;
    private String title;
    private String bookDesc;
    private double price;
    private String genre;
    private String publisher;
    private java.sql.Date publicationDate;
    private int copiesSold;

    @ManyToOne
    private Author author;
}
