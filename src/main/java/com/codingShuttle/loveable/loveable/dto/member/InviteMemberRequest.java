package com.codingShuttle.loveable.loveable.dto.member;

import com.codingShuttle.loveable.loveable.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
