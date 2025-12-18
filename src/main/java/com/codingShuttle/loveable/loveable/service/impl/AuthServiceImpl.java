package com.codingShuttle.loveable.loveable.service.impl;

import com.codingShuttle.loveable.loveable.dto.auth.AuthResponse;
import com.codingShuttle.loveable.loveable.dto.auth.LoginRequest;
import com.codingShuttle.loveable.loveable.dto.auth.SignupRequest;
import com.codingShuttle.loveable.loveable.error.BadRequestException;
import com.codingShuttle.loveable.loveable.mapper.UserMapper;
import com.codingShuttle.loveable.loveable.repository.UserRepository;
import com.codingShuttle.loveable.loveable.security.AuthUtil;
import com.codingShuttle.loveable.loveable.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.codingShuttle.loveable.loveable.entity.User;

@RequiredArgsConstructor
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {


    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    AuthUtil authUtil;
    AuthenticationManager authenticationManager;

    @Override
    public AuthResponse signup(SignupRequest request) {

        userRepository.findByUsername(request.username()).ifPresent(user -> {
            throw new BadRequestException("User already exists with username: "+request.username());
        });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(user);

        String token = authUtil.generateAccessToken(user); //Getting token from the util for like 10 mins only

        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(),request.password())
        );

        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);

        return new AuthResponse(token,userMapper.toUserProfileResponse(user));
    }
}
