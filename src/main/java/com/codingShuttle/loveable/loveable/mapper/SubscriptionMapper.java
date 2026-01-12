package com.codingShuttle.loveable.loveable.mapper;

import com.codingShuttle.loveable.loveable.dto.subscription.PlanResponse;
import com.codingShuttle.loveable.loveable.dto.subscription.SubscriptionResponse;
import com.codingShuttle.loveable.loveable.entity.Plan;
import com.codingShuttle.loveable.loveable.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanResponse toPlanResponse(Plan plan);
}
