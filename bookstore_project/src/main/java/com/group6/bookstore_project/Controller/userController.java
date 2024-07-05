package com.group6.bookstore_project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group6.bookstore_project.Model.Payment;
import com.group6.bookstore_project.Model.User;
import com.group6.bookstore_project.Repository.paymentRepo;
import com.group6.bookstore_project.Repository.userRepo;





/*
 * @Author Neica 
 */

@RestController
public class userController {
    
    @Autowired
    private userRepo userRepo;

    @Autowired
    private paymentRepo paymentRepo;

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

    // update a user
    @PutMapping("/user/update/{userName}")
    public String updateUser(@PathVariable String userName, @RequestBody User user) {
        User updatedUser = userRepo.findByUserName(userName);
        
        if(updatedUser == null){
            return "user not found";
        }
        updatedUser.setAddress(user.getAddress());
        updatedUser.setName(user.getName());
        updatedUser.setUserName(user.getUserName());
        updatedUser.setUserPassword(user.getUserPassword());
        userRepo.save(updatedUser);

        return "user is updated";
    }


    // add payment for a user
    @PostMapping("/CreatePayment/{userName}")
    public String addPayment(@PathVariable String userName, @RequestBody Payment payment) {
        User user = userRepo.findByUserName(userName);

        if(user == null){
            return "user not found";
        }
        payment.setUser(user);
        paymentRepo.save(payment);
      
        return "Payment added successfully";
    }
    
    // get all payment info for a user
    @GetMapping("/user/paymentInfo/{userName}")
    public Object getUserPayments(@PathVariable String userName) {
        User user = userRepo.findByUserName(userName);
        if(user == null){
            return "user not found";
        }
        List<Payment> payments = paymentRepo.findByUserUserName(userName);

        return payments;

    }

 


    


   

}
