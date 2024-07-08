package com.brandon.bookSearch.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookID;
    private String author;
    private String title;
    private int pages;
    private String genre;
    private int copiesSold;
    private double price;
    private String bookDesc;
    private String publisher;
    private java.sql.Date publicationDate;
}
