package com.brandon.bookSearch.Repository;

import com.brandon.bookSearch.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenre(String genre);
    @Query("SELECT b FROM Book b ORDER BY b.copiesSold DESC")
    List<Book> findTop10ByCopiesSold();

    List<Book> findByRatingGreaterThanEqual(double rating);

    List<Book> findByPublisher(String publisher);
}
