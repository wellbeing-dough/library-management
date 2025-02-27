package com.librarymanagement.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    RUNTIME_ERROR(500, "0001", "예상치 못한 예외입니다."),
    LOCK_ACQUISITION_EXCEPTION(408, "0002", "락 획득에 실패하였습니다"),
    BEST_SELLER_CACHE_OPERATION_EXCEPTION(500, "0003", "베스트 셀러 캐싱을 실패하였습니다."),

    USER_ALREADY_EXIST_ERROR(409, "0100", "해당 이메일을 갖는 유저가 이미 존재합니다."),
    USER_NOT_FOUND_ERROR(401, "0101", "해당 식별자를 갖는 유저가 존재하지 않습니다."),
    USER_EMAIL_NOT_FOUND_ERROR(404, "0102", "해당 이메일을 갖는 유저가 없습니다."),
    INVALID_PASSWORD_ERROR(401, "0103", "비밀번호가 잘못되었습니다."),

    TAG_NOT_FOUND_ERROR(404, "0200", "해당 식별자를 갖는 태그가 없습니다."),
    TAG_ALREADY_EXISTS_ERROR(409, "0201", "해당 이름을 갖는 태그가 존재합니다"),

    BOOK_TAG_ALREADY_EXISTS_ERROR(409, "0300", "해당 책은 이미 해당 태그가 추가된 상태 입니다."),

    AUTHORIZATION_HEADER_IS_NULL_ERROR(401, "0400", "헤더에 인증 정보가 없습니다."),
    HEADER_TYPE_IS_NOT_BEARER_ERROR(404, "0401", "헤더 타입이 Bearer가 아닙니다."),
    EXPIRED_TOKEN_ERROR(401, "0402", "토큰이 만료되었습니다."),
    INVALID_TOKEN_ERROR(401, "0403", "유효하지 않은 토큰입니다."),

    INVALID_INPUT_VALUE_ERROR(400, "0500", "입력값이 올바르지 않습니다."),

    BOOK_NOT_FOUND_ERROR(404, "0600", "해당 식별자를 갖는 책이 존재하지 않습니다."),
    BOOK_CAN_NOT_BE_DELETE_ERROR(409, "0601", "해당 도서는 삭제할 수 없습니다"),

    ALREADY_BORROWED_ERROR(409, "0700", "해당 도서는 이미 대출 중입니다."),
    ALREADY_RETURNED_ERROR(409, "0701", "해당 도서는 이미 반납 되었습니다."),
    LOAN_NOT_FOUND_ERROR(404, "0702", "해당 식별자를 갖는 대출 정보가 없습니다."),
    USER_DID_NOT_BORROW_BOOK_ERROR(400, "0703", "해당 도서는 해당 유저가 빌린게 아닙니다.")
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
