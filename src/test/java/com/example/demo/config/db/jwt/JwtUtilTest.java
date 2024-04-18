package com.example.demo.config.db.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.config.jwt.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JwtUtilTest {

    @Test
    public void extractToken() {

        /** 현재 날짜에서 1일을 더한 다음, */
        LocalDate expireDate = LocalDate.now().plusDays(1);

        /** 해당 날짜의 시작 시간을 기준으로 Instant 객체를 생성 */
        Instant expireInstant = expireDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

        /** Data 객체로 변환하여 만료 일자 설정 - 다음날 0시 */
        Date expireDt = Date.from(expireInstant);

        // 시그니쳐 HmacSHA256 (생략)
        // 추후 테스트 시 필요
        String SECRET_KEY = "";

        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
        String generateAccessToken =JWT.create().withSubject("JoGyeHyeon")
                                        .withExpiresAt(expireDt)
                                        .withIssuedAt(new Date())
                                        .withIssuer("TEST")
                                        .withClaim("roles", "ADMIN")
                                        .withClaim("username", "JoGyeHyeon")
                                        .sign(algorithm);

        // 복호화
        String getUsername = JWT.require(algorithm)
                                .build()
                                .verify(generateAccessToken)
                                .getClaims()
                                .get("username")
                                .asString();

        HttpServletRequest request = mock(HttpServletRequest.class);
        System.out.println(request.toString());

        /**
         *  when
         *  모의 객체의 메서드가 호출될 때
         *  어떤 동작을 수행할지를 지정하는 부분
         * */
        when(request.getHeader("Authorization")).thenReturn("Bearer "+getUsername);

        JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.extractToken(request);

        System.out.println("getUsername == "+ getUsername);
        System.out.println("token       == "+ token);

        assertEquals(getUsername, token);

    }
}