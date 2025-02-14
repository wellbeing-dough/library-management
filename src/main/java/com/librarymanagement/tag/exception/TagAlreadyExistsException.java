package com.librarymanagement.tag.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class TagAlreadyExistsException extends TagDomainLogicException {
    public TagAlreadyExistsException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
