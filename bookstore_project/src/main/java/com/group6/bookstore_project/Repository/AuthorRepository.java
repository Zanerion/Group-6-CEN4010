package com.group6.bookstore_project.Repository;

import com.group6.bookstore_project.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
