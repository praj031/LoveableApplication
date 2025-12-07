package com.codingShuttle.loveable.loveable.controller;

import com.codingShuttle.loveable.loveable.dto.auth.AuthResponse;
import com.codingShuttle.loveable.loveable.dto.auth.LoginRequest;
import com.codingShuttle.loveable.loveable.dto.auth.SignupRequest;
import com.codingShuttle.loveable.loveable.dto.auth.UserProfileResponse;
import com.codingShuttle.loveable.loveable.service.AuthService;
import com.codingShuttle.loveable.loveable.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {

    private AuthService authService;
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }

}
