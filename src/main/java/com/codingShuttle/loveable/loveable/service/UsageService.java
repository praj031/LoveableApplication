package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.subscription.PlanLimitsResponse;
import com.codingShuttle.loveable.loveable.dto.subscription.UsageTodayResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;


public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
