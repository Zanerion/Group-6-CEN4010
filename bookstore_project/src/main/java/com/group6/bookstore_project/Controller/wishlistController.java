package com.group6.bookstore_project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group6.bookstore_project.Model.Book;
import com.group6.bookstore_project.Model.Wishlist;
import com.group6.bookstore_project.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class wishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/create")
    public Wishlist createWishlist(@RequestParam String name, @RequestParam Long userId) {
        return wishlistService.createWishlist(name, userId);
    }

    @PostMapping("/add")
    public void addBookToWishlist(@RequestParam Long wishlistId, @RequestParam Long bookId) {
        wishlistService.addBookToWishlist(wishlistId, bookId);
    }

    @DeleteMapping("/remove")
    public void removeBookFromWishlist(@RequestParam Long wishlistId, @RequestParam Long bookId) {
        wishlistService.removeBookFromWishlist(wishlistId, bookId);
    }

    @GetMapping("/list")
    public List<Book> listBooksInWishlist(@RequestParam Long wishlistId) {
        return wishlistService.listBooksInWishlist(wishlistId);
    }
}
