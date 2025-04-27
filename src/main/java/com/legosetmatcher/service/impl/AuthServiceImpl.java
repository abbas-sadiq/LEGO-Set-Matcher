package com.legosetmatcher.service.impl;

import com.legosetmatcher.dto.request.RegisterRequest;
import com.legosetmatcher.dto.response.UserResponse;
import com.legosetmatcher.exception.ApiException;
import com.legosetmatcher.mapper.UserMapper;
import com.legosetmatcher.model.User;
import com.legosetmatcher.repository.UserRepository;
import com.legosetmatcher.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new ApiException("Username '" + request.getUsername() + "' already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }
}