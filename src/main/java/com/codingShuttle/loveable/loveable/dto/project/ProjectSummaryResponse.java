package com.codingShuttle.loveable.loveable.dto.project;

import com.codingShuttle.loveable.loveable.enums.ProjectRole;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        ProjectRole role
) {
}
