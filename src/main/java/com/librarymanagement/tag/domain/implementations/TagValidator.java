package com.librarymanagement.tag.domain.implementations;

import com.librarymanagement.common.exception.ErrorCode;
import com.librarymanagement.tag.exception.TagAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TagValidator {

    private final TagReader tagReader;

    public void isAlreadyExistsTagByName(String name) {
        if (tagReader.existsByName(name)) {
            throw new TagAlreadyExistsException(
                    ErrorCode.TAG_ALREADY_EXISTS_ERROR,
                    ErrorCode.TAG_ALREADY_EXISTS_ERROR.getStatusMessage()
            );
        }
    }
}
