package com.librarymanagement.user.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class UserAlreadyExistException extends UserDomainLogicException {
    public UserAlreadyExistException(ErrorCode errorCode, String logMessage, String data) {
        super(errorCode, logMessage + data);
    }
}
