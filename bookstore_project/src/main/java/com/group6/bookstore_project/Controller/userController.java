package com.group6.bookstore_project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group6.bookstore_project.Model.User;
import com.group6.bookstore_project.Repository.userRepo;

/*
 * @Author Neica 
 */

@RestController
public class userController {
    
    @Autowired
    private userRepo userRepo;

    @GetMapping("/users")
    public List<User> allUsers() {
       return userRepo.findAll();
    }

     @GetMapping("user/{userName}")
    public Optional<User> getUser(@PathVariable String userName) {
        return userRepo.findByUserName(userName);
    }

    @PostMapping("/user/create")
    public String createUser(@RequestBody User user) {
        if (userRepo.findByUserName(user.getUserName()).isPresent()) {
            return "User already exists";
        }
       userRepo.save(user);
       return "User is created";
    }

}
