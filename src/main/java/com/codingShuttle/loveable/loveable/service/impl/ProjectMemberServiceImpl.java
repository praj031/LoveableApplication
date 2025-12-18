package com.codingShuttle.loveable.loveable.service.impl;

import com.codingShuttle.loveable.loveable.dto.member.InviteMemberRequest;
import com.codingShuttle.loveable.loveable.dto.member.MemberResponse;
import com.codingShuttle.loveable.loveable.dto.member.UpdateMemberRoleRequest;
import com.codingShuttle.loveable.loveable.entity.Project;
import com.codingShuttle.loveable.loveable.entity.ProjectMember;
import com.codingShuttle.loveable.loveable.entity.ProjectMemberId;
import com.codingShuttle.loveable.loveable.entity.User;
import com.codingShuttle.loveable.loveable.mapper.ProjectMemberMapper;
import com.codingShuttle.loveable.loveable.repository.ProjectMemberRepository;
import com.codingShuttle.loveable.loveable.repository.ProjectRepository;
import com.codingShuttle.loveable.loveable.repository.UserRepository;
import com.codingShuttle.loveable.loveable.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;


    @Override
    //API to get all the project member
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        return projectMemberRepository.findByIdProjectId(projectId)
                                                    .stream()
                                                    .map(projectMemberMapper::toProjectMemberResponseFromMember)
                                                    .toList();

    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);


        User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if(invitee.getId().equals(userId)) {
            throw new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());

        if(projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Cannot invite once again");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);



        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId)
                .orElseThrow(() -> new RuntimeException("Member not found in project"));

        projectMemberRepository.deleteById(projectMemberId);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }


    ///  INTERNAL FUNCTIONS

    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}


/*
-- Will be taking care at the authorization part
 if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Not allowed");
        }

 */