package com.librarymanagement.user.exception;

import com.librarymanagement.common.exception.DomainLogicException;
import com.librarymanagement.common.exception.ErrorCode;

public class UserDomainLogicException extends DomainLogicException {
    public UserDomainLogicException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
