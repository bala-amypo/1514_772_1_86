package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String username, String password) {
        return "token-" + username;
    }

    public boolean validateToken(String token) {
        return token != null && !token.isBlank();
    }


    public String getUsernameFromToken(String token) {
        return token.replace("token-", "");
    }
}
