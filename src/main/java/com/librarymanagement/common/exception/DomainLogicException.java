package com.librarymanagement.common.exception;

public class DomainLogicException extends RootException {
    public DomainLogicException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
