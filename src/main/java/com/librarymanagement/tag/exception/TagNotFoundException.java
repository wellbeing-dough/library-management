package com.librarymanagement.tag.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class TagNotFoundException extends TagDomainLogicException {
    public TagNotFoundException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
