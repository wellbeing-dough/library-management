package com.librarymanagement.user.ui;

import com.librarymanagement.common.interceptor.annotation.Authenticated;
import com.librarymanagement.common.resolver.annotation.UserIdentifier;
import com.librarymanagement.user.application.UserService;
import com.librarymanagement.user.ui.dto.request.CreateUserHttpRequest;
import com.librarymanagement.user.ui.dto.request.SignInUserHttpRequest;
import com.librarymanagement.user.ui.dto.response.GetUserInfoHttpResponse;
import com.librarymanagement.user.ui.dto.response.JwtHttpResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원 가입")
    @PostMapping("/v1/users/sign-up")
    public ResponseEntity<JwtHttpResponse> signUp(@Valid @RequestBody CreateUserHttpRequest request) {
        String jwt = userService.createUser(request.getEmail(), request.getPassword(), request.getNickname());
        return ResponseEntity.ok().body(new JwtHttpResponse(jwt));
    }

    @Operation(summary = "로그인")
    @PostMapping("/v1/users/sign-in")
    public ResponseEntity<JwtHttpResponse> signIn(@Valid @RequestBody SignInUserHttpRequest request) {
        String jwt = userService.signIn(request.getEmail(), request.getPassword());
        return ResponseEntity.ok().body(new JwtHttpResponse(jwt));
    }

    @Operation(summary = "유저 정보 조회")
    @GetMapping("/v1/users")
    @Authenticated
    public ResponseEntity<GetUserInfoHttpResponse> getUserInfo(@UserIdentifier Long userId) {
        return ResponseEntity.ok().body(userService.getUserInfo(userId));
    }

}
