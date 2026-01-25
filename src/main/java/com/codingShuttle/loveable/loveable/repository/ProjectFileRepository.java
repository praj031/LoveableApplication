package com.codingShuttle.loveable.loveable.repository;

import com.codingShuttle.loveable.loveable.entity.ProjectFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectFileRepository extends JpaRepository<ProjectFile,Long> {

    //Porject file repo to store the project files
    Optional<ProjectFile> findByProjectIdAndPath(Long projectId, String cleanPath);

    List<ProjectFile> findByProjectId(Long projectId);

}
