package com.codingShuttle.loveable.loveable.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
