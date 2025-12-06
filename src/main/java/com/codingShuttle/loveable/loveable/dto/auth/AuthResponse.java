package com.codingShuttle.loveable.loveable.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {

}