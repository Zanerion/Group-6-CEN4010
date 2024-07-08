package com.group6.bookstore_project.Repository;

import com.group6.bookstore_project.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}