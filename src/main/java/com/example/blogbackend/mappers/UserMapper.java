package com.example.blogbackend.mappers;

import com.example.blogbackend.dto.user.ProfileResponse;
import com.example.blogbackend.dto.user.RegisterRequest;
import com.example.blogbackend.entity.User;

import java.util.Date;
import java.util.UUID;


public class UserMapper {

    public static User mapToUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setFullName(registerRequest.fullName());
        user.setPassword(registerRequest.password());
        user.setEmail(registerRequest.email());
        user.setCreateTime(new Date());
        user.setDateOfBirth(registerRequest.dateOfBirth());
        user.setPhoneNumber(registerRequest.phoneNumber());
        user.setGender(registerRequest.gender());
        return user;
    }


    public static ProfileResponse mapToProfileDTO(User user) {
        return ProfileResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .birthDate(user.getDateOfBirth())
                .phoneNumber(user.getPhoneNumber())
                .gender(user.getGender())
                .build();
    }

}
