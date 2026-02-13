package com.codingShuttle.loveable.loveable.mapper;


import com.codingShuttle.loveable.loveable.dto.project.ProjectResponse;
import com.codingShuttle.loveable.loveable.dto.project.ProjectSummaryResponse;
import com.codingShuttle.loveable.loveable.entity.Project;
import com.codingShuttle.loveable.loveable.enums.ProjectRole;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project, ProjectRole role);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> project);


}
