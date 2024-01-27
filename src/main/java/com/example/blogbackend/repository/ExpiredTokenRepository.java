package com.example.blogbackend.repository;

import com.example.blogbackend.entity.ExpiredToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface ExpiredTokenRepository extends JpaRepository<ExpiredToken, Long> {

    Optional<ExpiredToken> findById(UUID id);

}
