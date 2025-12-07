package com.codingShuttle.loveable.loveable.service.impl;

import com.codingShuttle.loveable.loveable.dto.subscription.PlanResponse;
import com.codingShuttle.loveable.loveable.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
