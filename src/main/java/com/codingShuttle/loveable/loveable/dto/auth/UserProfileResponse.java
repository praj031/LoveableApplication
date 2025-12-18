package com.codingShuttle.loveable.loveable.dto.auth;

public record UserProfileResponse(
        Long id,
        String username,
        String name
) {
}
