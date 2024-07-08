package com.brandon.bookSearch.Repository;

import com.brandon.bookSearch.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}