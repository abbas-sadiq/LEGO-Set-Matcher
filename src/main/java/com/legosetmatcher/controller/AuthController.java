package com.legosetmatcher.controller;

import com.legosetmatcher.exception.ApiResponse;
import com.legosetmatcher.model.User;
import com.legosetmatcher.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<User>> register(@RequestBody Map<String, String> credentials) {
        User user = new User();
        user.setUsername(credentials.get("username"));
        user.setPassword(passwordEncoder.encode(credentials.get("password")));
        User savedUser = userRepository.save(user);
        ApiResponse<User> response = new ApiResponse<>(true, savedUser, null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}