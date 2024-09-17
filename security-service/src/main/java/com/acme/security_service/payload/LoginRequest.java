package com.acme.security_service.payload;

public record LoginRequest(String email, String password) {
}