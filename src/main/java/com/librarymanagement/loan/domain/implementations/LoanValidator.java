package com.librarymanagement.loan.domain.implementations;

import com.librarymanagement.common.exception.ErrorCode;
import com.librarymanagement.loan.domain.entity.Loan;
import com.librarymanagement.loan.exception.AlreadyBorrowedException;
import com.librarymanagement.loan.exception.AlreadyReturnedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoanValidator {

    private final LoanReader loanReader;

    public void isPossibleToBorrow(Long bookId) {
        loanReader.readNonReturnOptionalByBookId(bookId)
                .ifPresent(loan -> {
                    throw new AlreadyBorrowedException(
                            ErrorCode.ALREADY_BORROWED_ERROR,
                            ErrorCode.ALREADY_BORROWED_ERROR.getStatusMessage()
                    );
                });
    }


    public void isPossibleToReturn(Loan loan) {
        if (loan.getReturnDate() != null) {
            throw new AlreadyReturnedException(
                    ErrorCode.ALREADY_RETURNED_ERROR,
                    ErrorCode.ALREADY_RETURNED_ERROR.getStatusMessage()
            );
        }

    }
}
