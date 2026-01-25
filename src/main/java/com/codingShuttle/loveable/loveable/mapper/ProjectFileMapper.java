package com.codingShuttle.loveable.loveable.mapper;

import com.codingShuttle.loveable.loveable.dto.project.FileNode;
import com.codingShuttle.loveable.loveable.entity.ProjectFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    List<FileNode> toListOfFileNode(List<ProjectFile> projectFileList);
}
