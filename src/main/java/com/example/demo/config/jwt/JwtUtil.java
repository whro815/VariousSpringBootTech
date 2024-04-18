package com.example.demo.config.jwt;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class JwtUtil {

    public String extractToken(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return getTokenFromHeader(headerAuth);
        }
        return null;
    }

     public String getTokenFromHeader(String headerAuth) {
        return headerAuth.substring(7);
    }

}
