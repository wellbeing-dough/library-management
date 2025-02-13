package com.librarymanagement.user.ui;

import com.librarymanagement.common.interceptor.annotation.Authenticated;
import com.librarymanagement.common.resolver.annotation.UserIdentifier;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Operation(summary = "회원 가입")
    @PostMapping("/v1/users")
    @Authenticated
    public ResponseEntity<HttpStatus> createUser(@UserIdentifier Long userId) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!" + userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
