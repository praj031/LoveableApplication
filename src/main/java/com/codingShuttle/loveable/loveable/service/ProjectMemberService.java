package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.member.InviteMemberRequest;
import com.codingShuttle.loveable.loveable.dto.member.MemberResponse;
import com.codingShuttle.loveable.loveable.dto.member.UpdateMemberRoleRequest;
import com.codingShuttle.loveable.loveable.entity.ProjectMember;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId);

    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
