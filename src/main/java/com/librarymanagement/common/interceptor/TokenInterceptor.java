package com.librarymanagement.common.interceptor;

import com.librarymanagement.auth.application.AuthService;
import com.librarymanagement.common.interceptor.annotation.Authenticated;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;



@Slf4j
@RequiredArgsConstructor
@Component
public class TokenInterceptor implements HandlerInterceptor {

    private final AuthService authService;

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object handler) {
        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {  //preflight 통과하도록 설정
            return true;
        }

        if (!(handler instanceof final HandlerMethod handlerMethod)) { // handler가 컨트롤러인지 확인, mvc에서 정적 파일 요청도 가능 -> 컨트롤러가 아니면 뒤의 로직 스킵
            return true;
        }

        if (handlerMethod.hasMethodAnnotation(Authenticated.class)) { // 컨트롤러 메서드가 인증처리가 필요한 메서드인 경우
            String token = authService.getAuthorizationToken(request.getHeader("Authorization"));
            if (!authService.isValidToken(token)) { // 토큰 유효성 검사
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 상태 코드 설정
                return false;
            }
        }

        return true;
    }

}
