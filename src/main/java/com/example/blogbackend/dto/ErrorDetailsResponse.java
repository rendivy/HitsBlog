package com.example.blogbackend.dto;

import lombok.Builder;

@Builder
public record ErrorDetailsResponse(
        String message,
        Integer status
) {}
