package com.librarymanagement.book.ui.dto.response;

import com.librarymanagement.book.domain.emuns.LoanStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetBookHttpResponse {

    private Long bookId;
    private String title;
    private String author;
    private String loanStatus;

    public GetBookHttpResponse(Long bookId, String title, String author, LoanStatus loanStatus) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.loanStatus = loanStatus.getValue();
    }
}
