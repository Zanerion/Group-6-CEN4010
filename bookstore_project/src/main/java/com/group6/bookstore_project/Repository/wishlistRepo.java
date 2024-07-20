package com.group6.bookstore_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group6.bookstore_project.Model.Wishlist;

@Repository
public interface wishlistRepo extends JpaRepository<Wishlist, Long> {
}
