package com.librarymanagement.book.ui.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetBookInfoHttpResponse {

    private final Long bookId;
    private final String title;
    private final String author;
    private final String publisher;
    private final String loanStatus;
    private final Long loanCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private final LocalDateTime publishedAt;


    public GetBookInfoHttpResponse(Long bookId, String title, String author, String publisher, String loanStatus, Long loanCount, LocalDateTime publishedAt) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.loanStatus = loanStatus;
        this.loanCount = loanCount;
        this.publishedAt = publishedAt;
    }
}
