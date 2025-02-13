package com.librarymanagement.book.ui.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class updateBookHttpRequest {

    private Long bookId;
    private String title;
    private String author;
    private String publisher;
}
