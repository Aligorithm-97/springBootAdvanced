package com.example.springadvanced.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserCredentials {
    private String username;
    private String password;
}
