package com.example.blogbackend.dto;

import lombok.Builder;

@Builder
public record ErrorDTO(
        String message,
        Integer status
) {}
