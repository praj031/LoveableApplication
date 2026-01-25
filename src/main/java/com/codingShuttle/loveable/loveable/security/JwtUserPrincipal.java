package com.codingShuttle.loveable.loveable.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public record JwtUserPrincipal(
        Long userId,
        String usename,
        List<GrantedAuthority> authorities
)
{
    //Use this class to store the JWT pricipal
}
