package com.librarymanagement.tag.exception;

import com.librarymanagement.common.exception.DomainLogicException;
import com.librarymanagement.common.exception.ErrorCode;

public class BookTagDomainLogicException extends DomainLogicException {
    public BookTagDomainLogicException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
