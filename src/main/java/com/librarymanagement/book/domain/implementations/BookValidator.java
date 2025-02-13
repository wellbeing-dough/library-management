package com.librarymanagement.book.domain.implementations;

import com.librarymanagement.book.domain.emuns.LoanStatus;
import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.book.exception.BookCannotBeDeletedException;
import com.librarymanagement.common.exception.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class BookValidator {

    public void isPossibleToDelete(Book book) {
        if (book.getLoanStatus() == LoanStatus.BORROWED) {
            throw new BookCannotBeDeletedException(
                    ErrorCode.BOOK_CAN_NOT_BE_DELETE_ERROR,
                    ErrorCode.BOOK_CAN_NOT_BE_DELETE_ERROR.getStatusMessage(),
                    " 책의 상태가 대출 상태입니다."
            );
        }
    }
}
