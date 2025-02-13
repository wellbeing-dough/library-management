package com.librarymanagement.book.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class BookCannotBeDeletedException extends BookDomainLogicException {
    public BookCannotBeDeletedException(ErrorCode errorCode, String logMessage, String reason) {
        super(errorCode, logMessage);
    }
}
