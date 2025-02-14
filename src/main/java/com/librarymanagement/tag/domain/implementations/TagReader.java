package com.librarymanagement.tag.domain.implementations;

import com.librarymanagement.common.exception.ErrorCode;
import com.librarymanagement.tag.domain.entity.Tag;
import com.librarymanagement.tag.exception.TagNotFoundException;
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

    public Tag readById(Long tagId) {
        return tagRepository.findById(tagId)
                .orElseThrow(() ->
                        new TagNotFoundException(
                                ErrorCode.TAG_NOT_FOUND_ERROR,
                                ErrorCode.TAG_NOT_FOUND_ERROR.getStatusMessage()
                        )
                );
    }

    public boolean existsByName(String name) {
        return tagRepository.existsByName(name);
    }
}
