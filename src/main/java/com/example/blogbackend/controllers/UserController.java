package com.example.blogbackend.controllers;


import com.example.blogbackend.auth.JwtService;
import com.example.blogbackend.dto.TokenResponse;
import com.example.blogbackend.dto.user.ProfileResponse;
import com.example.blogbackend.dto.user.RegisterRequest;
import com.example.blogbackend.entity.User;
import com.example.blogbackend.service.UserService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@Data
@Log4j2
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("register")
    public ResponseEntity<TokenResponse> registerUser(@RequestBody RegisterRequest requestDto) {
        return ResponseEntity.ok(userService.registerUser(requestDto));
    }

    @GetMapping("profile")
    public ResponseEntity<ProfileResponse> getUserProfile(@AuthenticationPrincipal User userDetails) {
        var userEmail = userDetails.getId();
        return ResponseEntity.ok(userService.getUserProfile(userEmail));
    }

}
