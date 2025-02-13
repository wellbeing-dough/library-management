package com.librarymanagement.user.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class UserNotFoundException extends UserDomainLogicException {
    public UserNotFoundException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
