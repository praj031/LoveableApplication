package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.subscription.CheckoutRequest;
import com.codingShuttle.loveable.loveable.dto.subscription.CheckoutResponse;
import com.codingShuttle.loveable.loveable.dto.subscription.PortalResponse;
import com.codingShuttle.loveable.loveable.dto.subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
