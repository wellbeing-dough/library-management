package com.librarymanagement.user.domian.implementations;

import com.librarymanagement.common.exception.ErrorCode;
import com.librarymanagement.user.exception.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserReader userReader;

    public void isAlreadyExistsByEmail(String email) {
        if (userReader.existsByEmail(email)) {
            throw new UserAlreadyExistException(
                    ErrorCode.USER_ALREADY_EXIST_ERROR,
                    ErrorCode.USER_ALREADY_EXIST_ERROR.getStatusMessage(),
                    " findBy: " + email
            );
        }
    }
}
