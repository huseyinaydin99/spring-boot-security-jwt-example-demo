package com.huseyinaydin.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 @author Huseyin_Aydin
 @since 1994
 @category Spring Boot canım
 *
 * 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private String userName;
    private String password;
}
