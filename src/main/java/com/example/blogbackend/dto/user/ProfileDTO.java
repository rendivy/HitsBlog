package com.example.blogbackend.dto.user;

import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Builder
public record ProfileDTO(
        UUID id,
        String email,
        String fullName,
        Date birthDate,
        String phoneNumber
){}
