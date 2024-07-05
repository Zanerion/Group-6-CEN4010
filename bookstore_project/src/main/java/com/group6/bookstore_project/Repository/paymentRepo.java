package com.group6.bookstore_project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group6.bookstore_project.Model.Payment;


/*
 * @Author Neica 
 */

public interface paymentRepo extends JpaRepository< Payment, Long> {

    List<Payment> findByUserUserName(String userName);
    
}
