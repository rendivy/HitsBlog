package com.example.blogbackend.controllers;


import com.example.blogbackend.dto.RegisterDTO;
import com.example.blogbackend.service.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@Data
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterDTO registerDTO) {
        userService.registerUser(registerDTO);
    }

}
