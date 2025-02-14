package com.librarymanagement.tag.domain.implementations;

import com.librarymanagement.tag.domain.entity.Tag;
import com.librarymanagement.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TagReader {

    private final TagRepository tagRepository;

    public List<Tag> readAll() {
        return tagRepository.findAll();
    }
}
