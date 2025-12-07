package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.subscription.PlanResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
