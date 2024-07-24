package com.brandon.bookSearch.Service;

import com.brandon.bookSearch.Repository.BookRepository;
import com.brandon.bookSearch.Entity.Book;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }
    public List<Book> getTopSellers() {
        return bookRepository.findTop10ByCopiesSold();
    }
    public List<Book> getBooksByRating(double rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }
    public void applyDiscountByPublisher(String publisher, double discountPercentage) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        for (Book book : books) {
            BigDecimal discount = book.getPrice().multiply(BigDecimal.valueOf(discountPercentage / 100));
            BigDecimal newPrice = book.getPrice().subtract(discount);
            book.setPrice(newPrice);
        }
        bookRepository.saveAll(books);
    }
}
