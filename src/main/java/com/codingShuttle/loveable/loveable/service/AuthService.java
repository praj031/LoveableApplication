package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.auth.AuthResponse;
import com.codingShuttle.loveable.loveable.dto.auth.LoginRequest;
import com.codingShuttle.loveable.loveable.dto.auth.SignupRequest;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
