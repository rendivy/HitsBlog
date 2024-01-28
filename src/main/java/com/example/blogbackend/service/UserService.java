package com.example.blogbackend.service;


import com.example.blogbackend.auth.JwtService;
import com.example.blogbackend.dto.TokenDTO;
import com.example.blogbackend.dto.user.ProfileDTO;
import com.example.blogbackend.dto.user.RegisterDTO;
import com.example.blogbackend.entity.User;
import com.example.blogbackend.mappers.UserMapper;
import com.example.blogbackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final JwtService jwtService;


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findUserById(id);
    }


    @Transactional
    public TokenDTO registerUser(RegisterDTO registerDTO) {
        User user = UserMapper.mapToUser(registerDTO);
        userRepository.save(user);
        return TokenDTO.builder()
                .token(jwtService.generateToken(user.getId(), user.getEmail()))
                .build();
    }


    public ProfileDTO getUserProfile(UUID id) {
        var user = userRepository.findById(id);
        return UserMapper.mapToProfileDTO(user.orElseThrow());
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

}

