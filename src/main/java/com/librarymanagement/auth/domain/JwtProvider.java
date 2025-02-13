package com.librarymanagement.auth.domain;

import com.librarymanagement.common.exception.AuthenticationException;
import com.librarymanagement.common.exception.ErrorCode;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtProvider {

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.secretKey}")
    private String secretKey;

    private final int YEAR_TO_MINUTES = 525600;

    public String makeJwtToken(final Long userId) {
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer(issuer)
                .setIssuedAt(now)
                .setExpiration(createExpiration(YEAR_TO_MINUTES, now))
                .claim("userId", userId)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    private Date createExpiration(final int minutes, final Date now) {
        return new Date(now.getTime() + Duration.ofMinutes(minutes).toMillis());
    }

    public HashMap<String, Object> parseJwtToken(String token) {
        loggingTokenInfo(token);
        return getParsedTokenDataHashMap(token);
    }

    private void loggingTokenInfo(final String token) {
        log.info("*******Accesstoken : {}", token);
    }

    private HashMap<String, Object> getParsedTokenDataHashMap(String token) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("token", token);
        Claims claims = (Claims) parseToken(token);
        hashMap.put("claims", claims);
        return hashMap;
    }

    /**
     * 토큰 검증 메서드
     *
     * @param token :
     * @return : 토큰안에 들어있는 유저 아이디 값
     * @throws ExpiredJwtException
     */
    public Object parseToken(final String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isValidToken(final String token) {
        try {
            parseToken(token);
        } catch (final ExpiredJwtException expiredJwtException) {
            throw new AuthenticationException(ErrorCode.EXPIRED_TOKEN_ERROR, ErrorCode.EXPIRED_TOKEN_ERROR.getStatusMessage());
        } catch (final JwtException jwtException) {
            throw new AuthenticationException(ErrorCode.INVALID_TOKEN_ERROR, ErrorCode.INVALID_TOKEN_ERROR.getStatusMessage());
        }

        return true;
    }
}
