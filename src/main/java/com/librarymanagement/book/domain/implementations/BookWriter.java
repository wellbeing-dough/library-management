package com.librarymanagement.book.domain.implementations;

import com.librarymanagement.book.domain.emuns.LoanStatus;
import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Transactional
public class BookWriter {

    private final BookRepository bookRepository;


    public Book createBook(String title, String author, String publisher, LocalDateTime publishedAt) {
        Book book = createBookEntity(title, author, publisher, publishedAt);
        return bookRepository.save(book);
    }

    private Book createBookEntity(String title, String author, String publisher, LocalDateTime publishedAt) {
        return Book.builder()
                .title(title)
                .author(author)
                .publisher(publisher)
                .publishedAt(publishedAt)
                .loanStatus(LoanStatus.AVAILABLE)
                .loanCount(0L)
                .build();
    }

    public void write(Book book) {
        bookRepository.save(book);
    }
}
