package com.librarymanagement.book.exception;

import com.librarymanagement.common.exception.DomainLogicException;
import com.librarymanagement.common.exception.ErrorCode;

public class BookDomainLogicException extends DomainLogicException {
    public BookDomainLogicException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
