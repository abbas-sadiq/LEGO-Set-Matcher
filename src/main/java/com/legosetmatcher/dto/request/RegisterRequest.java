package com.legosetmatcher.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}