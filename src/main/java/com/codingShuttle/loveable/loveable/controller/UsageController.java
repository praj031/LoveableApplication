package com.codingShuttle.loveable.loveable.controller;

import com.codingShuttle.loveable.loveable.dto.subscription.PlanLimitsResponse;
import com.codingShuttle.loveable.loveable.dto.subscription.UsageTodayResponse;
import com.codingShuttle.loveable.loveable.service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")
public class UsageController {

    private final UsageService usageService;

}
