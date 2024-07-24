package com.brandon.bookSearch.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

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


    @Column(name = "copies_sold")
    private BigInteger copiesSold;

    private BigDecimal price;
    @Column(name = "book_desc")
    private String bookDesc;

    private String publisher;

    @Column(name = "publication_date")
    private String publicationDate;

    private double rating;
}
