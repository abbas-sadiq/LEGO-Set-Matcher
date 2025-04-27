// src/main/java/com/legosetmatcher/service/AuthService.java
package com.legosetmatcher.service;

import com.legosetmatcher.dto.response.UserResponse;
import com.legosetmatcher.dto.request.RegisterRequest;

public interface AuthService {
    UserResponse register(RegisterRequest request);
}
