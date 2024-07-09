package com.group6.bookstore_project.Controller;

import com.group6.bookstore_project.Model.Author;
import com.group6.bookstore_project.Model.Book;
import com.group6.bookstore_project.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @GetMapping("/books/{authorId}")
    public List<Book> getBooksByAuthor(@PathVariable Long authorId) {
        return authorService.getBooksByAuthor(authorId);
    }
}
