package com.brandon.bookSearch.Service;

import com.brandon.bookSearch.Repository.BookRepository;
import com.brandon.bookSearch.Entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

public List<Book> getBooksByGenre(String genre) {
    return bookRepository.findByGenre(genre);
}

public List<Book> getTopSellers() {
    return bookRepository.findTop10ByOrderByCopiesSoldDesc();
}

public List<Book> getBooksByRating(double rating) {
    return bookRepository.findByRatingGreaterThanEqual(rating);
}
