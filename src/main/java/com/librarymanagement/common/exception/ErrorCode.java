package com.librarymanagement.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    RUNTIME_ERROR(500, "0001", "예상치 못한 예외입니다."),

    USER_ALREADY_EXIST_ERROR(409, "0100", "해당 이메일을 갖는 유저가 이미 존재합니다."),

    AUTHORIZATION_HEADER_IS_NULL(401, "0400", "헤더에 인증 정보가 없습니다."),
    HEADER_TYPE_IS_NOT_BEARER(404, "0401", "헤더 타입이 Bearer가 아닙니다."),
    EXPIRED_TOKEN_ERROR(401, "0402", "토큰이 만료되었습니다."),
    INVALID_TOKEN_ERROR(401, "0403", "유효하지 않은 토큰입니다."),

    INVALID_INPUT_VALUE(400, "0500", "입력값이 올바르지 않습니다"),
    ;

    private final int status;
    private final String code;
    private final String statusMessage;

    ErrorCode(int status, String code, String statusMessage) {
        this.status = status;
        this.code = code;
        this.statusMessage = statusMessage;
    }

}
