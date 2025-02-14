package com.librarymanagement.tag.domain.implementations;

import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.common.exception.ErrorCode;
import com.librarymanagement.tag.domain.entity.Tag;
import com.librarymanagement.tag.exception.BookTagAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookTagValidator {

    private final BookTagReader bookTagReader;

    public void isAlreadyExistsBookTag(Tag tag, Book book) {
        if (bookTagReader.existsByTagIdAndBookId(tag.getId(), book.getId())) {
            throw new BookTagAlreadyExistsException(
                    ErrorCode.BOOK_TAG_ALREADY_EXISTS_ERROR,
                    ErrorCode.BOOK_TAG_ALREADY_EXISTS_ERROR.getStatusMessage()
            );
        }
    }
}
