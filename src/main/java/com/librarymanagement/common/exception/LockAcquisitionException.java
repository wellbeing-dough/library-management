package com.librarymanagement.common.exception;

public class LockAcquisitionException extends RootException {
    public LockAcquisitionException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
