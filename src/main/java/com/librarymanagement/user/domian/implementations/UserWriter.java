package com.librarymanagement.user.domian.implementations;

import com.librarymanagement.user.domian.entity.User;
import com.librarymanagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class UserWriter {

    private final UserRepository userRepository;

    public User createUser(String email, String password, String nickname) {
        User user = createUserEntity(email, password, nickname);
        return userRepository.save(user);
    }

    private User createUserEntity(String email, String password, String nickname) {
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
