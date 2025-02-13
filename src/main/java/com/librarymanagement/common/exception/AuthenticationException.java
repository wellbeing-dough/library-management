package com.librarymanagement.common.exception;

public class AuthenticationException extends RootException {
    public AuthenticationException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
