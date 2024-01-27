package com.example.blogbackend.config;

import com.example.blogbackend.auth.JwtService;
import com.example.blogbackend.entity.User;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {
    private final JwtService jwtService;


    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain) throws ServletException, IOException {
        var requestHeader = request.getHeader("Authorization");

        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            var jwtToken = requestHeader.substring("Bearer ".length());



            if (jwtService.validateToken(jwtToken)) {

                User user = jwtService.getUserFromToken(jwtToken);

                UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        true,
                        true,
                        true,
                        true,
                        user.getAuthorities()
                );


                var authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));


                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request, response);
            }
            else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        else {
            filterChain.doFilter(request, response);
        }
    }
}
