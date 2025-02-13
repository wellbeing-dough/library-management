package com.librarymanagement.loan.exception;

import com.librarymanagement.common.exception.ErrorCode;

public class UserDidNotBorrowBookException extends LoanDomainLogicException {
    public UserDidNotBorrowBookException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
