package com.librarymanagement.auth.application;

import com.librarymanagement.auth.domain.JwtProvider;
import com.librarymanagement.common.exception.AuthenticationException;
import com.librarymanagement.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

    private static final String BEARER = "Bearer ";
    private final JwtProvider jwtProvider;

    public String getAuthorizationToken(String authorizationHeader) {
        validationAuthorizationHeader(authorizationHeader);
        return extractToken(authorizationHeader);
    }

    private void validationAuthorizationHeader(String header) {
        log.info("*******header : {}", header);
        if (header == null) {
            throw new AuthenticationException(
                    ErrorCode.AUTHORIZATION_HEADER_IS_NULL_ERROR,
                    ErrorCode.AUTHORIZATION_HEADER_IS_NULL_ERROR.getStatusMessage()
            );
        }
        if (!header.startsWith(BEARER)) {
            throw new AuthenticationException(
                    ErrorCode.HEADER_TYPE_IS_NOT_BEARER_ERROR,
                    ErrorCode.HEADER_TYPE_IS_NOT_BEARER_ERROR.getStatusMessage()
            );
        }
    }

    private String extractToken(String authorizationHeader) {
        return authorizationHeader.substring(BEARER.length());
    }

    public boolean isValidToken(String token) {
        return jwtProvider.isValidToken(token);
    }

    public HashMap<String, Object> parseJwtToken(String token) {
        return jwtProvider.parseJwtToken(token);
    }

}
