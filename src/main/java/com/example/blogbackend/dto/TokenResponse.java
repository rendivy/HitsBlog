package com.example.blogbackend.dto;

import lombok.Builder;

@Builder
public record TokenResponse(String token) {
}
