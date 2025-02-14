package com.librarymanagement.tag.domain.implementations;

import com.librarymanagement.tag.domain.entity.Tag;
import com.librarymanagement.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class TagWriter {

    private final TagRepository tagRepository;

    public void createTag(String name) {
        Tag tag = createTagEntity(name);
        tagRepository.save(tag);
    }

    private Tag createTagEntity(String name) {
        return Tag.builder()
                .name(name)
                .build();
    }
}
