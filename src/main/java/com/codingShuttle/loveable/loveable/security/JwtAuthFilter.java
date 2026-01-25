package com.codingShuttle.loveable.loveable.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    private final AuthUtil authUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Used to check each request, to verify token, to check validity of token.

      log.info("System out === Incoming Request : {}",request.getRequestURI());

      final String requestHeaderToken = request.getHeader("Authorization");
        if (requestHeaderToken == null || !requestHeaderToken.startsWith("Bearer ")) { // To check the token holods the value like "Bearer"
            filterChain.doFilter(request, response);//It will move to next filter
            return;
        }
        String jwttoken = requestHeaderToken.split("Bearer ")[1]; // Split to get the first part
        JwtUserPrincipal user = authUtil.verifyAccessToken(jwttoken);

        if(user != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UsernamePasswordAuthenticationToken authenticatiocnToken = new UsernamePasswordAuthenticationToken(user,null,user.authorities());
            SecurityContextHolder.getContext().setAuthentication(authenticatiocnToken);
        }
        filterChain.doFilter(request,response);




    }




}
