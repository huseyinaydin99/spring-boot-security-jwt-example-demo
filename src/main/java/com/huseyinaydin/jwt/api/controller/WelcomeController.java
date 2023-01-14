package com.huseyinaydin.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huseyinaydin.jwt.api.entity.AuthRequest;
import com.huseyinaydin.jwt.api.util.JwtUtil;

/**
 * 
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot canım
 *
 * 
 */

@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Hoşgeldiniz... || Hüseyin Aydın";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password || geçersiz kullanıcı adı veya şifre");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
