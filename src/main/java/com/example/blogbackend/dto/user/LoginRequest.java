package com.example.blogbackend.dto.user;


public record LoginRequest(
        String email,
        String password
) { }


