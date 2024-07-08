package com.brandon.bookSearch.Controller;

import com.brandon.bookSearch.Service.BookService;
import com.brandon.bookSearch.Entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/allBooks")
    public String getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Book List</title></head><body><h1>Book List</h1><ul>");
        for (Book book : books) {
            sb.append("<li><strong>Title: ").append(book.getTitle()).append("</strong></li>");
            sb.append("<li>ID: ").append(book.getBookID()).append("</li>");
            sb.append("<li>Author: ").append(book.getAuthor()).append("</li>");
            sb.append("<li>Pages: ").append(book.getPages()).append("</li>");
            sb.append("<li>Genre: ").append(book.getGenre()).append("</li>");
            sb.append("<li>Copies Sold: ").append(book.getCopiesSold()).append("</li>");
            sb.append("<li>Price: $").append(book.getPrice()).append("</li>");
            sb.append("<li>Description: ").append(book.getBookDesc()).append("</li>");
            sb.append("<li>Publisher: ").append(book.getPublisher()).append("</li>");
            sb.append("<li>Publication Date: ").append(book.getPublicationDate()).append("</li>");
            sb.append("<br><br>");
        }
        sb.append("</ul></body></html>");
        return sb.toString();
    }

    @GetMapping("/getSortByNameAtoZ")
    public String getSortByNameAtoZ() {
        List<Book> books = bookService.getAllBooksSortedByTitle();
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Sorted Book List</title></head><body><h1>Sorted Book List</h1><ul>");
        for (Book book : books) {
            sb.append("<li><strong>Title: ").append(book.getTitle()).append("</strong></li>");
            sb.append("<li>ID: ").append(book.getBookID()).append("</li>");
            sb.append("<li>Author: ").append(book.getAuthor()).append("</li>");
            sb.append("<li>Pages: ").append(book.getPages()).append("</li>");
            sb.append("<li>Genre: ").append(book.getGenre()).append("</li>");
            sb.append("<li>Copies Sold: ").append(book.getCopiesSold()).append("</li>");
            sb.append("<li>Price: $").append(book.getPrice()).append("</li>");
            sb.append("<li>Description: ").append(book.getBookDesc()).append("</li>");
            sb.append("<li>Publisher: ").append(book.getPublisher()).append("</li>");
            sb.append("<li>Publication Date: ").append(book.getPublicationDate()).append("</li>");
            sb.append("<br><br>");
        }
        sb.append("</ul></body></html>");
        return sb.toString();
    }
}
