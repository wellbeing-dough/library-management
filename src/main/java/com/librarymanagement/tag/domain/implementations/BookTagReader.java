package com.librarymanagement.tag.domain.implementations;

import com.librarymanagement.tag.domain.entity.BookTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookTagReader {

    private final BookTagRepository bookTagRepository;


    public boolean existsByTagIdAndBookId(Long tagId, Long bookId) {
        return bookTagRepository.existsByTagIdAndBookId(tagId, bookId);
    }
}
