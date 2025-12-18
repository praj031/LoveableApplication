package com.codingShuttle.loveable.loveable.service.impl;

import com.codingShuttle.loveable.loveable.dto.project.ProjectRequest;
import com.codingShuttle.loveable.loveable.dto.project.ProjectResponse;
import com.codingShuttle.loveable.loveable.dto.project.ProjectSummaryResponse;
import com.codingShuttle.loveable.loveable.entity.Project;
import com.codingShuttle.loveable.loveable.entity.ProjectMember;
import com.codingShuttle.loveable.loveable.entity.ProjectMemberId;
import com.codingShuttle.loveable.loveable.entity.User;
import com.codingShuttle.loveable.loveable.enums.ProjectRole;
import com.codingShuttle.loveable.loveable.error.ResourceNotFoundException;
import com.codingShuttle.loveable.loveable.mapper.ProjectMapper;
import com.codingShuttle.loveable.loveable.repository.ProjectMemberRepository;
import com.codingShuttle.loveable.loveable.repository.ProjectRepository;
import com.codingShuttle.loveable.loveable.repository.UserRepository;
import com.codingShuttle.loveable.loveable.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        //Method which will create the project based on the user we have selected[User 1]
        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();
        project = projectRepository.save(project);
        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(),owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);


        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {

        //Method that will return all the project for a particular user.
        //Converting our list to project to a list of summary response, as over here we are returning all the project for the user.

        //Method 1
//        return projectRepository.findAllAccessibleByUser(userId)
//                .stream()
//                .map(project -> projectMapper.toProjectSummaryResponse(project))
//                .collect(Collectors.toList());

        //Method 2
        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);

    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {

        Project project = getAccessibleProjectById(id,userId);
        return projectMapper.toProjectResponse(project);
        //Later we do the exception handling


    }



    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {

        Project project = getAccessibleProjectById(id,userId);
        project.setName(request.name());//This will update the project for us
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {

        Project project = getAccessibleProjectById(id,userId);
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);

    }


    //Internal Function -- Basically those methods which are used again & again we can call it in here.
    //Reason -- To make our code dry..
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleByUser(projectId,userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project ",projectId.toString()));
    }
    //Now, whenever the exception is thrown it will be caught by exception handler, we created in error.ResourceNotFoundException


}
