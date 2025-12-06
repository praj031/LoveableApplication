package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
