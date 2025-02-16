package com.librarymanagement.common.exception;

public class CacheOperationException extends RootException {
    public CacheOperationException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
