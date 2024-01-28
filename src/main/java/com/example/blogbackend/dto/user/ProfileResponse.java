package com.example.blogbackend.dto.user;

import com.example.blogbackend.entity.Gender;
import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Builder
public record ProfileResponse(
        UUID id,
        String email,
        String fullName,
        Date birthDate,
        String phoneNumber,
        Gender gender
){}
