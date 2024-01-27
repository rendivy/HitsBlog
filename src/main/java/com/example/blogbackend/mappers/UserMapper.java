package com.example.blogbackend.mappers;

import com.example.blogbackend.dto.user.ProfileDTO;
import com.example.blogbackend.dto.user.RegisterDTO;
import com.example.blogbackend.entity.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;


public class UserMapper {

    public static User mapToUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setFullName(registerDTO.fullName());
        user.setPassword(registerDTO.password());
        user.setEmail(registerDTO.email());
        user.setCreateTime(new Date());
        user.setDateOfBirth(registerDTO.dateOfBirth());
        user.setPhoneNumber(registerDTO.phoneNumber());
        user.setGender(registerDTO.gender());
        return user;
    }


    public static ProfileDTO mapToProfileDTO(User user) {
        return ProfileDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .birthDate(user.getDateOfBirth())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

}
