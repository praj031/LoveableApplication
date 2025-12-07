package com.codingShuttle.loveable.loveable.service.impl;

import com.codingShuttle.loveable.loveable.dto.project.ProjectRequest;
import com.codingShuttle.loveable.loveable.dto.project.ProjectResponse;
import com.codingShuttle.loveable.loveable.dto.project.ProjectSummaryResponse;
import com.codingShuttle.loveable.loveable.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
