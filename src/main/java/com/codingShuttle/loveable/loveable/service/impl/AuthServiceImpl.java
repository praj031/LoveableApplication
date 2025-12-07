package com.codingShuttle.loveable.loveable.service.impl;

import com.codingShuttle.loveable.loveable.dto.auth.AuthResponse;
import com.codingShuttle.loveable.loveable.dto.auth.LoginRequest;
import com.codingShuttle.loveable.loveable.dto.auth.SignupRequest;
import com.codingShuttle.loveable.loveable.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
