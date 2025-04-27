// src/main/java/com/legosetmatcher/controller/UserController.java
package com.legosetmatcher.controller;

import com.legosetmatcher.dto.request.RegisterRequest;
import com.legosetmatcher.exception.ApiResponse;
import com.legosetmatcher.model.User;
import com.legosetmatcher.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        ApiResponse<User> response = new ApiResponse<>(true, createdUser, null); // Wrapping in ApiResponse
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }




}