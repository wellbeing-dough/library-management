package com.librarymanagement.loan.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class AlreadyBorrowedException extends LoanDomainLogicException {

    public AlreadyBorrowedException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
