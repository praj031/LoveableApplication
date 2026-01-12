package com.codingShuttle.loveable.loveable.config;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StripeConfig {

    @Value("${stripe.api.secretKey}")
    private String stripeSecretKey;
    @Value("${stripe.api.publishKey}")
    private String stripePublishKey;
    @Value("${stripe.webhook.secreteKey}")
    private String stripeWebhookSecreteKey;

    //@PostConstuct helps us to give logs
    @PostConstruct
    public void init() {
        System.out.println("✅ STRIPE LOADED: " + stripeSecretKey.substring(0, 100) + "...");
        Stripe.apiKey = stripeSecretKey;  // Initialize Stripe SDK
    }

}
