package com.librarymanagement.user.domian.implementations;

import com.librarymanagement.common.exception.ErrorCode;
import com.librarymanagement.user.domian.entity.User;
import com.librarymanagement.user.exception.UserNotFoundException;
import com.librarymanagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserReader {

    private final UserRepository userRepository;

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User readByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                ErrorCode.USER_EMAIL_NOT_FOUND_ERROR,
                                ErrorCode.USER_EMAIL_NOT_FOUND_ERROR.getStatusMessage()
                        )
                );
    }

    public User readById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                ErrorCode.USER_NOT_FOUND_ERROR,
                                ErrorCode.USER_NOT_FOUND_ERROR.getStatusMessage()
                        )
                );
    }
}
