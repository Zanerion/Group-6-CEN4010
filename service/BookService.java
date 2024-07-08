package com.group6.bookstore_project.service;

import com.group6.bookstore_project.Repository.BookRepository;
import com.group6.bookstore_project.Model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAllBooksSortedByTitle() {
        List<Book> books = bookRepository.findAll();
        books.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        return books;
    }
}

