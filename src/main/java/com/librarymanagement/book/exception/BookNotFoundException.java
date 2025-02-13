package com.librarymanagement.book.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class BookNotFoundException extends BookDomainLogicException {
    public BookNotFoundException(ErrorCode errorCode, String logMessage, String data) {
        super(errorCode, logMessage);
    }
}
