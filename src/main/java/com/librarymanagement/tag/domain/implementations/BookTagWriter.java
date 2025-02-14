package com.librarymanagement.tag.domain.implementations;

import com.librarymanagement.book.domain.entity.Book;
import com.librarymanagement.tag.domain.entity.BookTag;
import com.librarymanagement.tag.domain.entity.BookTagRepository;
import com.librarymanagement.tag.domain.entity.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class BookTagWriter {

    private final BookTagRepository bookTagRepository;;

    public void writeBookTag(Tag tag, Book book) {
        BookTag bookTag = createBookTagEntity(book.getId(), tag.getId());
        bookTagRepository.save(bookTag);
    }

    private BookTag createBookTagEntity(Long bookId, Long tagId) {
        return BookTag.builder()
                .bookId(bookId)
                .tagId(tagId)
                .build();
    }

}
