package com.librarymanagement.common.resolver;

import com.librarymanagement.auth.application.AuthService;
import com.librarymanagement.common.interceptor.annotation.Authenticated;
import com.librarymanagement.common.resolver.annotation.UserIdentifier;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class UserIdentifierArgumentResolver implements HandlerMethodArgumentResolver {

    private final AuthService authService;

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        if (!parameter.hasMethodAnnotation(Authenticated.class)) {
            return false;
        }

        return parameter.getParameterType().equals(Long.class) &&
                parameter.hasParameterAnnotation(UserIdentifier.class);
    }

    @Override
    public Long resolveArgument(final MethodParameter parameter,
                                final ModelAndViewContainer mavContainer,
                                final NativeWebRequest webRequest,
                                final WebDataBinderFactory binderFactory) {
        final String authorizationHeader = webRequest.getHeader("Authorization");
        String authorizationToken = authService.getAuthorizationToken(authorizationHeader);
        return extractUserIdFromJwtToken(authorizationToken);
    }

    private Long extractUserIdFromJwtToken(final String token) {
        HashMap<String, Object> parseJwtTokenMap = authService.parseJwtToken(token);
        Claims claims = (Claims) parseJwtTokenMap.get("claims");
        return getUserIdFromToken(claims);
    }

    private Long getUserIdFromToken(final Claims claims) {
        Object userId = claims.get("userId");
        return Long.parseLong((String) userId);
    }
}