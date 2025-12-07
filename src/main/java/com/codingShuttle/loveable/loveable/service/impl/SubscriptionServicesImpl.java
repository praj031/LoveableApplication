package com.codingShuttle.loveable.loveable.service.impl;

import com.codingShuttle.loveable.loveable.dto.subscription.CheckoutRequest;
import com.codingShuttle.loveable.loveable.dto.subscription.CheckoutResponse;
import com.codingShuttle.loveable.loveable.dto.subscription.PortalResponse;
import com.codingShuttle.loveable.loveable.dto.subscription.SubscriptionResponse;
import com.codingShuttle.loveable.loveable.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServicesImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
