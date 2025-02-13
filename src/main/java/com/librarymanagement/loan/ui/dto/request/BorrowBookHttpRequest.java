package com.librarymanagement.loan.ui.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BorrowBookHttpRequest {

    @Schema(description = "빌릴 책 id", example = "1")
    @NotNull(message = "빌릴 책 id 는 필수 입니다")
    private Long bookId;

}
