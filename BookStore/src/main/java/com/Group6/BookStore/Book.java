package com.Group6.BookStore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Indexed;

@Entity
public class Book {
    @Id
    private Integer bookId;
    private String title;
    private String isbnNumber;
    

    public Integer getBookId() {
        return bookId;
    }

    public void setId(Integer bookId) {
        this.bookId = bookId;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }
}
