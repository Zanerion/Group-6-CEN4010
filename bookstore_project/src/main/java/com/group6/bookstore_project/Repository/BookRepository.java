package com.brandon.bookSearch.Repository;

import com.brandon.bookSearch.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
    List<Book> findByAuthorId(Long authorId);
    List<Book> findByGenre(String genre);

}
