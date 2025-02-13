package com.librarymanagement.loan.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class LoanNotFoundException extends LoanDomainLogicException {
    public LoanNotFoundException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
