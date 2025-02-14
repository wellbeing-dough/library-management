package com.librarymanagement.tag.application;

import com.librarymanagement.tag.domain.entity.Tag;
import com.librarymanagement.tag.domain.implementations.TagReader;
import com.librarymanagement.tag.domain.implementations.TagValidator;
import com.librarymanagement.tag.domain.implementations.TagWriter;
import com.librarymanagement.tag.ui.dto.response.GetTagHttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagReader tagReader;
    private final TagValidator tagValidator;
    private final TagWriter tagWriter;

    public List<GetTagHttpResponse> getTagList() {
        List<Tag> tags = tagReader.readAll();
        return tags.stream()
                .map(tag -> new GetTagHttpResponse(tag.getId(), tag.getName()))
                .toList();
    }

    public void createTag(String name) {
        tagValidator.isAlreadyExistsTagByName(name);
        tagWriter.createTag(name);
    }
}
