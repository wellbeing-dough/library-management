package com.librarymanagement.book.ui.dto.response;

import com.librarymanagement.book.domain.emuns.LoanStatus;
import lombok.Getter;

@Getter
public class GetBookHttpResponse {

    private final Long bookId;
    private final String title;
    private final String loanStatus;

    public GetBookHttpResponse(Long bookId, String title, LoanStatus loanStatus) {
        this.bookId = bookId;
        this.title = title;
        this.loanStatus = loanStatus.getValue();
    }
}
