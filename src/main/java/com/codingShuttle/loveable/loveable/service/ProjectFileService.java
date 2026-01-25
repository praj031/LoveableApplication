package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.project.FileContentResponse;
import com.codingShuttle.loveable.loveable.dto.project.FileNode;

import java.util.List;

public interface ProjectFileService {


    void saveFile(Long projectId, String filePath, String fileContent);

    List<FileNode> getFileTree(Long projectId);

    FileContentResponse getFileContent(Long projectId, String path);
}


/*
List<FileNode> getFileTree(Long projectId);

FileContentResponse getFileContent(Long projectId, String path);

void saveFile(Long projectId, String filePath, String fileContent);
*/
