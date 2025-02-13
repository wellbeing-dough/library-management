package com.librarymanagement.user.domian.implementations;

import com.librarymanagement.common.exception.ErrorCode;
import com.librarymanagement.user.domian.entity.User;
import com.librarymanagement.user.exception.InvalidPasswordException;
import com.librarymanagement.user.exception.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserReader userReader;
    private final PasswordEncoder passwordEncoder;

    public void isAlreadyExistsByEmail(String email) {
        if (userReader.existsByEmail(email)) {
            throw new UserAlreadyExistException(
                    ErrorCode.USER_ALREADY_EXIST_ERROR,
                    ErrorCode.USER_ALREADY_EXIST_ERROR.getStatusMessage(),
                    " findBy: " + email
            );
        }
    }

    public void validatePassword(String email, String password, User user) {
        String userPassword = passwordEncoder.encode(email, password);
        if (!passwordEncoder.matches(userPassword, user.getPassword())) {
            throw new InvalidPasswordException(
                    ErrorCode.INVALID_PASSWORD_ERROR,
                    ErrorCode.INVALID_PASSWORD_ERROR.getStatusMessage()
            );
        }
    }
}
