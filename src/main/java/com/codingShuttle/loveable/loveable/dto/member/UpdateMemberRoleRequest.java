package com.codingShuttle.loveable.loveable.dto.member;

import com.codingShuttle.loveable.loveable.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(@NotNull ProjectRole role) {
}
