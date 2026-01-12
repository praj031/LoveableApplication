package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.subscription.CheckoutRequest;
import com.codingShuttle.loveable.loveable.dto.subscription.CheckoutResponse;
import com.codingShuttle.loveable.loveable.dto.subscription.PortalResponse;
import com.stripe.model.StripeObject;

import java.util.Map;


public interface PaymentProcessorService {

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}
