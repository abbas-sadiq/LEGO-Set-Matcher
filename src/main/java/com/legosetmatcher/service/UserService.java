package com.legosetmatcher.service;


import com.legosetmatcher.dto.UserDTO;
import com.legosetmatcher.service.impl.UserServiceImpl;

import java.util.List;

public interface UserService{

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long id);


    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}

