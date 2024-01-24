package com.example.blogbackend.exception.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User with this credentials not found");
    }
}

