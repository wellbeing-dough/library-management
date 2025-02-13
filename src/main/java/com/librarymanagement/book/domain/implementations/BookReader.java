package com.librarymanagement.book.domain.implementations;

import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.book.exception.BookNotFoundException;
import com.librarymanagement.book.repository.BookRepository;
import com.librarymanagement.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookReader {

    private final BookRepository bookRepository;

    public Book readById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                ErrorCode.BOOK_NOT_FOUND_ERROR,
                                ErrorCode.BOOK_NOT_FOUND_ERROR.getStatusMessage(),
                                " find By " + bookId
                        )
                );
    }
}
