package com.librarymanagement.book.ui.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateBookHttpRequest {

    private String title;
    private String author;
    private String publisher;

}
