package com.example.blogbackend.dto;

import com.example.blogbackend.entity.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
