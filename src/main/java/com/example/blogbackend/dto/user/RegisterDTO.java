package com.example.blogbackend.dto.user;

import com.example.blogbackend.entity.Gender;
import lombok.Builder;


import java.util.Date;

@Builder
public record RegisterDTO(
        Gender gender,
        String email,
        String password,
        Date dateOfBirth,
        String fullName,
        String phoneNumber
) { }
