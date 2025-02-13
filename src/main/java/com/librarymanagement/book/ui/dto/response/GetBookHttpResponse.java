package com.librarymanagement.book.ui.dto.response;

import lombok.Getter;

@Getter
public class GetBookHttpResponse {

    private final Long bookId;
    private final String title;
    private final String author;
    private final String publisher;

    public GetBookHttpResponse(Long bookId, String title, String author, String publisher) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
}
