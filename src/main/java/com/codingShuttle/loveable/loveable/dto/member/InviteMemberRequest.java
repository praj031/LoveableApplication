package com.codingShuttle.loveable.loveable.dto.member;

import com.codingShuttle.loveable.loveable.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email @NotNull String username,
        @NotNull ProjectRole role
) {
}
