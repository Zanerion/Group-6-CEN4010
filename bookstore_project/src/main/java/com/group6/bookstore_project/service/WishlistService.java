package com.group6.bookstore_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group6.bookstore_project.Model.Book;
import com.group6.bookstore_project.Model.User;
import com.group6.bookstore_project.Model.Wishlist;
import com.group6.bookstore_project.Repository.BookRepository;
import com.group6.bookstore_project.Repository.userRepo;
import com.group6.bookstore_project.Repository.wishlistRepo;

@Service
public class WishlistService {
    @Autowired
    private wishlistRepo wishlistRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private userRepo userRepository;

    public Wishlist createWishlist(String name, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Wishlist wishlist = new Wishlist();
        wishlist.setName(name);
        wishlist.setUser(user);
        return wishlistRepository.save(wishlist);
    }

    public void addBookToWishlist(Long wishlistId, Long bookId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow(() -> new RuntimeException("Wishlist not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        wishlist.getBooks().add(book);
        wishlistRepository.save(wishlist);
    }

    public void removeBookFromWishlist(Long wishlistId, Long bookId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow(() -> new RuntimeException("Wishlist not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        wishlist.getBooks().remove(book);
        wishlistRepository.save(wishlist);
    }

    public List<Book> listBooksInWishlist(Long wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow(() -> new RuntimeException("Wishlist not found"));
        return wishlist.getBooks();
    }
}