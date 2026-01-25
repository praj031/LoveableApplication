package com.codingShuttle.loveable.loveable.security;


import com.codingShuttle.loveable.loveable.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

@Component
public class AuthUtil {

    @Value("${jwt.secret-key}")
    private String jwtSecretkey;

    //private UserPrincipal userPrincipal;



    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecretkey.getBytes(StandardCharsets.UTF_8));
        //Converts the bytes array into secrete key for us.
    }

    //This class will generate the token fo the login
    public String generateAccessToken(User user) {

        return Jwts.builder()
                .subject(user.getUsername())
                .claim("userId",user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*60*24*5))
                .signWith(getSecretKey())
                .compact();

    }

    public JwtUserPrincipal verifyAccessToken(String token){

        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        //We are taking in the secrete keym and then parsing the token and getting the payloads

        Long userId = Long.parseLong(claims.get("userId", String.class));
        String username = claims.getSubject();

        return new JwtUserPrincipal(userId,username,new ArrayList<>());
        //This will verify the user and return us the JWT valid priciple that we can use it later

    }

    public long getCurrentUserId(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !(authentication.getPrincipal() instanceof JwtUserPrincipal userPrincipal)){
            throw new AuthenticationCredentialsNotFoundException("No JWT found");
        }

        return userPrincipal.userId();

    }



}
