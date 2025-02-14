package com.librarymanagement.tag.ui.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateTagHttpRequest {

    @Schema(description = "추가할 태그 이름", example = "자기 개발")
    @NotBlank(message = "추가할 태그 이름은 필수 입니다")
    @Size(min = 1, max = 50, message = "태그는 최소 한글자에서 최대 50글자 입니다")
    private String name;

}
