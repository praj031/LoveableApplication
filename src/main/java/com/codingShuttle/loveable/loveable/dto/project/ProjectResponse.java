package com.codingShuttle.loveable.loveable.dto.project;

import com.codingShuttle.loveable.loveable.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
}
