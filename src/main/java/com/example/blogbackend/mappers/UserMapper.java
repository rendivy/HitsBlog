package com.example.blogbackend.mappers;

import com.example.blogbackend.dto.RegisterDTO;
import com.example.blogbackend.entity.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class UserMapper {

    public User mapToUser(RegisterDTO registerDTO) {
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

}
