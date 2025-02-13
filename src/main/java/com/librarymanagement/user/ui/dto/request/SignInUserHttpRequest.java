package com.librarymanagement.user.ui.dto.request;

import com.librarymanagement.user.domian.component.NormalEmail;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SignInUserHttpRequest {

    @Schema(description = "회원가입 할 이메일", example = "kdw990202@naver.com")
    @NotBlank(message = "이메일 입력값은 필수 입니다")
    @NormalEmail
    private String email;

    @Schema(description = "유저 비밀번호", example = "asdasdasd!!")
    @NotBlank(message = "비밀번호는 필수 입니다")
    @Pattern(
            regexp = "^(?=.*[!@#$%^&*?~_]).{10,}$",
            message = "비밀번호는 10자 이상이어야 하며, 하나 이상의 특수문자를 포함해야 합니다."
    )
    private String password;

}
