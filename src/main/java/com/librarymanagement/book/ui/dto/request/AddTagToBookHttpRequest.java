package com.librarymanagement.book.ui.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddTagToBookHttpRequest {
    @Schema(description = "추가할 태그 id")
    @NotNull(message = "추가할 태그 id는 필수 입니다")
    private Long tagId;

    @Schema(description = "추가할 책 id")
    @NotNull(message = "추가할 책 id는 필수 입니다")
    private Long bookId;

}
