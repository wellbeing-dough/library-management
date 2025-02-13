package com.librarymanagement.book.domain.implementations;

import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class BookWriter {

    private final BookRepository bookRepository;


    public Book createBook(String title, String author, String publisher) {
        Book book = createBookEntity(title, author, publisher);
        return bookRepository.save(book);
    }

    private Book createBookEntity(String title, String author, String publisher) {
        return Book.builder()
                .title(title)
                .author(author)
                .publisher(publisher)
                .build();
    }
}
