package com.librarymanagement.tag.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class BookTagAlreadyExistsException extends BookTagDomainLogicException {
    public BookTagAlreadyExistsException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
