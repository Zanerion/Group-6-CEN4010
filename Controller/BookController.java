package com.brandon.bookSearch.Controller;

import com.brandon.bookSearch.Service.BookService;
import com.brandon.bookSearch.Entity.Book;
import org.springframework.web.bind.annotation.*;

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
        return formatBooks(books);
    }

    @GetMapping("/getSortByNameAtoZ")
    public String getSortByNameAtoZ() {
        List<Book> books = bookService.getAllBooksSortedByTitle();
        return formatBooks(books);
    }

    @GetMapping("/genre/{genre}")
    public String getBooksByGenre(@PathVariable String genre) {
        List<Book> books = bookService.getBooksByGenre(genre);
        return formatBooks(books);
    }

    private String formatBooks(List<Book> books) {
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
            sb.append("<li>Rating: ").append(book.getRating()).append("<br></li><br>");
            sb.append("<br><br>");
        }
        sb.append("</ul></body></html>");
        return sb.toString();
    }

    @GetMapping("/topSellers")
    public String getTopSellers() {
        List<Book> books = bookService.getTopSellers();
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Top Sellers</title></head><body><h1>Top Sellers</h1><ul>");
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
            sb.append("<li>Publication Date: ").append(book.getPublicationDate()).append("</li>");;
            sb.append("<li>Rating: ").append(book.getRating()).append("<br></li><br>");
            sb.append("<br><br>");
            counter++;
            if (counter == 10)
            {
              break;
            }
        }
        sb.append("</ul></body></html>");
        return sb.toString();
    }
    @GetMapping("/booksByRating")
    public String getBooksByRating(@RequestParam double rating) {
        List<Book> books = bookService.getBooksByRating(rating);
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Books By Rating</title></head><body><h1>Books By Rating</h1><ul>");
        for (Book book : books) {
            sb.append("<li><b>Title: ").append(book.getTitle()).append("</b><br>");
            sb.append("ID: ").append(book.getBookID()).append("<br>");
            sb.append("Author: ").append(book.getAuthor()).append("<br>");
            sb.append("Pages: ").append(book.getPages()).append("<br>");
            sb.append("Genre: ").append(book.getGenre()).append("<br>");
            sb.append("Copies Sold: ").append(book.getCopiesSold()).append("<br>");
            sb.append("Price: $").append(book.getPrice()).append("<br>");
            sb.append("Description: ").append(book.getBookDesc()).append("<br>");
            sb.append("Publisher: ").append(book.getPublisher()).append("<br>");
            sb.append("Publication Date: ").append(book.getPublicationDate()).append("<br>");
            sb.append("Rating: ").append(book.getRating()).append("<br></li><br>");
        }
        sb.append("</ul></body></html>");
        return sb.toString();
    }
    @GetMapping("/discountBooksByPublisher")
    public String discountBooksByPublisher(@RequestParam String publisher, @RequestParam double discountPercentage) {
        bookService.applyDiscountByPublisher(publisher, discountPercentage);
        return "Discount applied to books published by " + publisher;
    }
}
