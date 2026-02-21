package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.deploy.DeployResponse;

public interface DeploymentService {

    DeployResponse deploy(Long projectId);
}
