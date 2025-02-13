package com.librarymanagement.book.application;

import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.book.domain.implementations.BookReader;
import com.librarymanagement.book.domain.implementations.BookWriter;
import com.librarymanagement.book.ui.dto.response.GetBookHttpResponse;
import com.librarymanagement.user.domian.entity.User;
import com.librarymanagement.user.domian.implementations.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookWriter bookWriter;
    private final UserReader userReader;
    private final BookReader bookReader;

    public Long createBook(String title, String author, String publisher, Long userId) {
        User user = userReader.readById(userId);
        Book book = bookWriter.createBook(title, author, publisher);
        return book.getId();
    }

    public GetBookHttpResponse getBookInfo(Long bookId) {
        Book book = bookReader.readById(bookId);
        return new GetBookHttpResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher());
    }
}
