package com.librarymanagement.user.ui.dto.response;

import lombok.Getter;

@Getter
public class GetUserInfoHttpResponse {

    private final Long userId;
    private final String email;
    private final String nickname;

    public GetUserInfoHttpResponse(Long userId, String email, String nickname) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
    }
}
