package com.group6.bookstore_project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group6.bookstore_project.Model.User;

/*
 * @Author Neica 
 */

public interface userRepo extends JpaRepository< User, Long> {

   Optional<User>  findByUserName(String userName);
   
}
