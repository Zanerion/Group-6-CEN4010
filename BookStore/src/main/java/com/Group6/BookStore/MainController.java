package com.Group6.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/demo")
public class MainController {
    
    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path="/demo")
    public @ResponseBody String addNewBook (@RequestParam String bookName) {
        Book b = new Book();
        b.setBookName(bookName);
        bookRepository.save(b);
        return "Saved";
    }
}
