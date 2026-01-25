package com.codingShuttle.loveable.loveable.service;

import com.codingShuttle.loveable.loveable.dto.auth.UserProfileResponse;



public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
