package com.group6.bookstore_project.Service;

import com.group6.bookstore_project.Model.Author;
import com.group6.bookstore_project.Model.Book;
import com.group6.bookstore_project.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Book> getBooksByAuthor(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow().getBooks();
    }
}
