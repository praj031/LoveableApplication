package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.project.FileContentResponse;
import com.codingShuttle.loveable.loveable.dto.project.FileNode;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
