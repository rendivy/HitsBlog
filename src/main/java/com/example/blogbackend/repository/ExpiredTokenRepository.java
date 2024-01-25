package com.example.blogbackend.repository;

public interface InvalidTokenRepository implements JpaRepository<InvalidToken, Long> {

    Optional<InvalidToken> findByToken(String token);

}
