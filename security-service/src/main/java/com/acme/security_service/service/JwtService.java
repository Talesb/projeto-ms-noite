package com.acme.security_service.service;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String JWT_SECRET;

    public String generateToken (UserDetails userDetails, List<String> roles) {
        Algorithm algorithm = Algorithm.HMAC512(JWT_SECRET);
        return JWT.create().withSubject(userDetails.getUsername())
                .withIssuedAt(LocalDateTime.now().toInstant(ZoneOffset.from(ZoneOffset.UTC)))
                .withExpiresAt(LocalDateTime.now().plusDays(2).toInstant(ZoneOffset.from(ZoneOffset.UTC)))
                .withIssuer("montadora@acme.com.br").withClaim("roles", roles).sign(algorithm);
    }
}
