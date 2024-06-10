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

    @PostMapping(path="/addNewBook")
    public @ResponseBody String addNewBook (@RequestParam String title) {
        Book b = new Book();
        b.settitle(title);
        bookRepository.save(b);
        return "Saved";
    }
}
