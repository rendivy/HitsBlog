package com.example.blogbackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, nullable = false, length = 30)
    @Size(min = 5, max = 50, message = "Email should contain between 5 and 50 characters")
    @NotBlank(message = "User email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @Column(nullable = false)
    private Date createTime = new Date();

    @Column(nullable = false)
    private Date dateOfBirth = new Date();

    @Column(unique = true)
    @Size(min = 5, max = 50, message = "Phone number should contain between 5 and 50 characters")
    @NotBlank(message = "User phone number cannot be empty")
    @Pattern(regexp = "^\\+\\d{11}$", message = "Phone number should be in the format +79999999999")
    private String phoneNumber;

    private Gender gender = Gender.MALE;

    @Size(min = 5, max = 50, message = "Name should contain between 5 and 50 characters")
    @NotBlank(message = "User name cannot be empty")
    private String fullName;

    @Size(min = 5, max = 50, message = "Password should contain between 5 and 50 characters")
    @NotBlank(message = "User password cannot be empty")
    private String password;
}
