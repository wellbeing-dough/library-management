package com.librarymanagement.loan.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class AlreadyReturnedException extends LoanDomainLogicException {

    public AlreadyReturnedException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
