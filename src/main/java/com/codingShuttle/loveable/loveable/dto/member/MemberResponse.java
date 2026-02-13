package com.codingShuttle.loveable.loveable.dto.member;



import com.codingShuttle.loveable.loveable.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
)


{



}