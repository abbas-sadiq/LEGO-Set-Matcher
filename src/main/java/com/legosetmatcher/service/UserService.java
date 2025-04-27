// src/main/java/com/legosetmatcher/service/UserService.java
package com.legosetmatcher.service;

import com.legosetmatcher.model.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);

}