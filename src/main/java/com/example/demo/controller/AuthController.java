package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,
                          JwtTokenProvider jwtTokenProvider,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest rr) {
        User user = User.builder()
                .name(rr.getName())
                .email(rr.getEmail())
                .password(rr.getPassword())
                .build();

        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest ar) {
        User user = userService.findByEmail(ar.getEmail());

        if (user != null && passwordEncoder.matches(ar.getPassword(), user.getPassword())) {
            String token = jwtTokenProvider.createToken(
                    user.getId(),
                    user.getEmail(),
                    user.getRole()
            );

            return ResponseEntity.ok(
                    new AuthResponse(token, user.getId(), user.getEmail(), user.getRole())
            );
        }

        return ResponseEntity.status(401).build();
    }
}
