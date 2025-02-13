package com.librarymanagement.common.exception;

import lombok.Getter;

@Getter
public class RootException extends RuntimeException {
    private final ErrorCode errorCode;

    public RootException(ErrorCode errorCode, String logMessage) {
        super(logMessage);
        this.errorCode = errorCode;
    }
}
