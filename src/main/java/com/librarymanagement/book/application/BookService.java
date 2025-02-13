package com.librarymanagement.book.application;

import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.book.domain.implementations.BookReader;
import com.librarymanagement.book.domain.implementations.BookValidator;
import com.librarymanagement.book.domain.implementations.BookWriter;
import com.librarymanagement.book.ui.dto.response.GetBookHttpResponse;
import com.librarymanagement.user.domian.entity.User;
import com.librarymanagement.user.domian.implementations.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookWriter bookWriter;
    private final UserReader userReader;
    private final BookReader bookReader;
    private final BookValidator bookValidator;

    public Long createBook(String title, String author, String publisher, Long userId) {
        User user = userReader.readById(userId);
        Book book = bookWriter.createBook(title, author, publisher);
        return book.getId();
    }

    public GetBookHttpResponse getBookInfo(Long bookId) {
        Book book = bookReader.readById(bookId);
        return new GetBookHttpResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(),
                book.getLoanStatus());
    }

    public void updateBook(Long bookId, String title, String author, String publisher, Long userId) {
        User user = userReader.readById(userId);
        Book book = bookReader.readById(bookId);
        book.updateInfo(title, author, publisher);
        bookWriter.write(book);
    }

    public void deleteBook(Long bookId, Long userId) {
        User user = userReader.readById(userId);
        Book book = bookReader.readById(bookId);
        bookValidator.isPossibleToDelete(book);
        book.mockDelete(LocalDateTime.now());
        bookWriter.write(book);
    }
}
