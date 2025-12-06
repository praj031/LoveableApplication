package com.codingShuttle.loveable.loveable.dto.auth;

public record SignupRequest(
        String email,
        String name,
        String password
) {
}
