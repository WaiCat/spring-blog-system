package com.sprint.mission.service.Impl;

import com.sprint.mission.dto.LoginRequest;
import com.sprint.mission.dto.LoginResponse;
import com.sprint.mission.dto.SignUpRequest;
import com.sprint.mission.dto.SignUpResponse;
import com.sprint.mission.entity.User;
import com.sprint.mission.jwp.JwtUtil;
import com.sprint.mission.repository.UserRepository;
import com.sprint.mission.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        String id = signUpRequest.getId();
        String password = signUpRequest.getPassword();
        String email = signUpRequest.getEmail();
        String nickname = signUpRequest.getNickname();

        validateId(id);
        validatePassword(password);
        validateEmail(email);
        validateNickname(nickname);

        User user = new User(id, BCrypt.hashpw(signUpRequest.getPassword(), BCrypt.gensalt()), email, nickname);
        userRepository.addUser(user);
        return SignUpResponse.builder()
                .success(true)
                .message("회원 가입이 완료되었습니다.")
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.getUser(loginRequest.getId());

        if (!BCrypt.checkpw(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtUtil.generateToken(user.getId());

        return LoginResponse.builder()
                .success(true)
                .token(token)
                .build();

    }

    private void validateId(String id) {
        //아이디 길이 조건 확인 (6 ~ 12자)
        if (id.length() < 6 || id.length() > 30) {
            throw new IllegalArgumentException("아이디는 6자 이상 12자 이하로 입력해주세요.");
        }

        //아이디 중복 확인
        if (userRepository.existUser(id)) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
    }

    private void validatePassword(String password) {
        //비밀번호: 12-50글자, 영문/숫자/특수문자(!@#$%^&*) 각 2글자 이상 포함
        if (password.length() < 12 || password.length() > 50) {
            throw new IllegalArgumentException("비밀번호는 12자 이상 50자 이하로 입력해주세요.");
        }

        int letters = 0;
        int digits = 0;
        int specials = 0;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                letters++;
            } else if (Character.isDigit(c)) {
                digits++;
            } else if ("!@#$%^&*".indexOf(c) >= 0) {
                specials++;
            }
        }

        //각 종류별 2개 이상 포함 확인
        if (letters < 2 || digits < 2 || specials < 2) {
            throw new IllegalArgumentException("비밀번호는 영문, 숫자, 특수문자(!@#$%^&*)를 각각 2자 이상 포함해야 합니다.");
        }
    }

    private void validateEmail(String email) {
        if (email.length() > 100) {
            throw new IllegalArgumentException("이메일은 100자 이하로 입력해주세요.");
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
        }
    }

    private void validateNickname(String nickname) {
        if (nickname.length() < 3 || nickname.length() > 50) {
            throw new IllegalArgumentException("닉네임은 3자 이상 50자 이하로 입력해주세요.");
        }

    }
}
