package com.group6.bookstore_project.Controller;

import java.util.List;


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

    // get all of the users
    @GetMapping("/users")
    public List<User> allUsers() {
       return userRepo.findAll();
    }

    // get a user by their username
    @GetMapping("user/{userName}")
    public Object getUser(@PathVariable String userName) {
        User user = userRepo.findByUserName(userName);
        if(user == null){
            return "user not found";
        }
        return user;
    }

    // create a user
    @PostMapping("/user/create")
    public String createUser(@RequestBody User user) {
        if (userRepo.findByUserName(user.getUserName()) != null) {
            return "User already exists";
        }
       userRepo.save(user);
       return "User is created";
    }

   

}
