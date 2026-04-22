package com.project.timetracker.security;

import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    public String createToken(String subject) {
        return subject;
    }

    public String getSubject(String token) {
        return token;
    }
}
