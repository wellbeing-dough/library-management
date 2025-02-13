package com.librarymanagement.book.ui.dto.response;

import com.librarymanagement.book.domain.emuns.LoanStatus;
import com.librarymanagement.loan.domain.entity.Loan;
import lombok.Getter;

@Getter
public class GetBookHttpResponse {

    private final Long bookId;
    private final String title;
    private final String author;
    private final String publisher;
    private final String loanStatus;

    public GetBookHttpResponse(Long bookId, String title, String author, String publisher, LoanStatus loanStatus) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.loanStatus = loanStatus.getValue();
    }
}
