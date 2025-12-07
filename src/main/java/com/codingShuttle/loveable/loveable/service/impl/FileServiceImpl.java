package com.codingShuttle.loveable.loveable.service.impl;

import com.codingShuttle.loveable.loveable.dto.project.FileContentResponse;
import com.codingShuttle.loveable.loveable.dto.project.FileNode;
import com.codingShuttle.loveable.loveable.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
