package com.librarymanagement.book.ui.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddTagToBookHttpRequest {

    private Long tagId;
    private Long bookId;

}
