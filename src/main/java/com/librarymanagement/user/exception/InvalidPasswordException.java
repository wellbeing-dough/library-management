package com.librarymanagement.user.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class InvalidPasswordException extends UserDomainLogicException {
    public InvalidPasswordException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
