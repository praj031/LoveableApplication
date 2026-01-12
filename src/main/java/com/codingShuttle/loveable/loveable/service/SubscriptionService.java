package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.subscription.CheckoutRequest;
import com.codingShuttle.loveable.loveable.dto.subscription.CheckoutResponse;
import com.codingShuttle.loveable.loveable.dto.subscription.PortalResponse;
import com.codingShuttle.loveable.loveable.dto.subscription.SubscriptionResponse;
import com.codingShuttle.loveable.loveable.enums.SubscriptionStatus;

import java.time.Instant;


public interface SubscriptionService {
    //SubscriptionResponse getCurrentSubscription(Long userId);
    /*
    Since we are handling dedicatly these methods in the PayementProcessorService, adding these in the comments only.
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);
    PortalResponse openCustomerPortal(Long userId);
     */

    SubscriptionResponse getCurrentSubscription();

    void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);

    void updateSubscription(String gatewaySubscriptionId, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId);

    void cancelSubscription(String gatewaySubscriptionId);

    void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd);

    void markSubscriptionPastDue(String subId);

    boolean canCreateNewProject();
}
