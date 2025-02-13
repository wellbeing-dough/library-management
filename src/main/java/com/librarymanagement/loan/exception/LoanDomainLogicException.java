package com.librarymanagement.loan.exception;

import com.librarymanagement.common.exception.DomainLogicException;
import com.librarymanagement.common.exception.ErrorCode;

public class LoanDomainLogicException extends DomainLogicException {
    public LoanDomainLogicException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
