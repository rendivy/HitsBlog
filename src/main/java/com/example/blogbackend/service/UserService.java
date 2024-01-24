package com.example.blogbackend.service;


import com.example.blogbackend.dto.RegisterDTO;
import com.example.blogbackend.entity.User;
import com.example.blogbackend.mappers.UserMapper;
import com.example.blogbackend.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;


@Service
@Data
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public void registerUser(RegisterDTO registerDTO) {
        User user = userMapper.mapToUser(registerDTO);
        userRepository.save(user);
    }

}
