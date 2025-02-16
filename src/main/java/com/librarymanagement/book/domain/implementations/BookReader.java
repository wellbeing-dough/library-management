package com.librarymanagement.book.domain.implementations;

import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.book.exception.BookNotFoundException;
import com.librarymanagement.book.repository.BookRepository;
import com.librarymanagement.book.ui.dto.response.GetBookHttpResponse;
import com.librarymanagement.common.domain.SortByType;
import com.librarymanagement.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<GetBookHttpResponse> readListByAuthor(String author, Long tagId, Pageable pageable, SortByType sortBy) {
        return bookRepository.findListByAuthor(author, tagId, pageable, sortBy);
    }

    public List<GetBookHttpResponse> readListByTitle(String title, Long tagId, Pageable pageable, SortByType sortBy) {
        return bookRepository.findListByTitle(title, tagId, pageable, sortBy);
    }

    public List<GetBookHttpResponse> getBestSeller() {
        return bookRepository.getBestSeller();
    }
}
