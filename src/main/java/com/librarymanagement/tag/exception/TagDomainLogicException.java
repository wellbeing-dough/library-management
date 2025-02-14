package com.librarymanagement.tag.exception;

import com.librarymanagement.common.exception.DomainLogicException;
import com.librarymanagement.common.exception.ErrorCode;

public class TagDomainLogicException extends DomainLogicException {
    public TagDomainLogicException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
