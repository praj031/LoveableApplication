package com.codingShuttle.loveable.loveable.service.impl;

import com.codingShuttle.loveable.loveable.dto.subscription.PlanLimitsResponse;
import com.codingShuttle.loveable.loveable.dto.subscription.UsageTodayResponse;
import com.codingShuttle.loveable.loveable.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
