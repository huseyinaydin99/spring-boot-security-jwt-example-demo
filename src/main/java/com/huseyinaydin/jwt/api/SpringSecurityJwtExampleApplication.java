package com.huseyinaydin.jwt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.huseyinaydin.jwt.api.entity.User;
import com.huseyinaydin.jwt.api.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot canım
 *
 * 
 */

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {
    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "huseyin", "11779955", "huso99999@gmail.com"),
                new User(102, "hasan", "11779955", "user1@gmail.com"),
                new User(103, "cumali", "11779955", "user2@gmail.com"),
                new User(104, "sebahattin", "11779955", "user3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
    }

}
