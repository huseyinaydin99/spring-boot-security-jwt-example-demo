package com.huseyinaydin.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huseyinaydin.jwt.api.entity.User;


/**
 * 
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot canım
 *
 * 
 */


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
