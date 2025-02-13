package com.librarymanagement.user.ui.dto.response;

import lombok.Getter;

@Getter
public class JwtHttpResponse {

    private final String accessToken;

    public JwtHttpResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
