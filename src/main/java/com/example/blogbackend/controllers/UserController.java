package com.example.blogbackend.controllers;


import com.example.blogbackend.dto.TokenDTO;
import com.example.blogbackend.dto.user.RegisterDTO;
import com.example.blogbackend.service.UserService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@Data
@Log4j2
public class UserController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<TokenDTO> registerUser(@RequestBody RegisterDTO requestDto) {
        return ResponseEntity.ok(userService.registerUser(requestDto));
    }

    @GetMapping("profile")
    public ResponseEntity<String> getUserProfile() {
        return ResponseEntity.ok("123");
    }

}
