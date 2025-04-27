// src/main/java/com/legosetmatcher/mapper/UserMapper.java
package com.legosetmatcher.mapper;

import com.legosetmatcher.dto.response.UserResponse;
import com.legosetmatcher.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse toResponse(User user) {
        return new UserResponse(user.getId(),user.getUsername());
    }
}