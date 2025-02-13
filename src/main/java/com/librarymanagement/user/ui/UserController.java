package com.librarymanagement.user.ui;

import com.librarymanagement.user.application.UserService;
import com.librarymanagement.user.ui.dto.request.CreateUserHttpRequest;
import com.librarymanagement.user.ui.dto.response.JwtHttpResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원 가입")
    @PostMapping("/v1/users")
    public ResponseEntity<JwtHttpResponse> createUser(@Valid @RequestBody CreateUserHttpRequest request) {
        String jwt = userService.createUser(request.getEmail(), request.getPassword(), request.getNickname());
        return ResponseEntity.ok().body(new JwtHttpResponse(jwt));
    }

}
