package com.librarymanagement.user.application;

import com.librarymanagement.auth.domain.JwtProvider;
import com.librarymanagement.user.domian.entity.User;
import com.librarymanagement.user.domian.implementations.PasswordEncoder;
import com.librarymanagement.user.domian.implementations.UserReader;
import com.librarymanagement.user.domian.implementations.UserValidator;
import com.librarymanagement.user.domian.implementations.UserWriter;
import com.librarymanagement.user.ui.dto.response.GetUserInfoHttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserWriter userWriter;
    private final UserReader userReader;
    private final UserValidator userValidator;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public String createUser(String email, String password, String nickname) {
        userValidator.isAlreadyExistsByEmail(email);
        User user = userWriter.createUser(email, passwordEncoder.encode(email, password), nickname);
        return jwtProvider.makeJwtToken(user.getId());
    }

    public String signIn(String email, String password) {
        User user = userReader.readByEmail(email);
        userValidator.validatePassword(email, password, user);
        return jwtProvider.makeJwtToken(user.getId());
    }

    public GetUserInfoHttpResponse getUserInfo(Long userId) {
        User user = userReader.readById(userId);
        return new GetUserInfoHttpResponse(user.getId(), user.getEmail(), user.getNickname());
    }
}
