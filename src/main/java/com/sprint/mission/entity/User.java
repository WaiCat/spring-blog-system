package com.sprint.mission.entity;

import com.sprint.mission.dto.SignUpRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
public class User implements Serializable {
    private String id;
    private String password;
    private String email;
    private String nickname;
    private Instant createdAt;

    public User(String id, String password, String email, String nickname) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.createdAt = Instant.now();
    }

    public User toUser(SignUpRequest signUpRequest) {
        return User.builder()
                .id(signUpRequest.getId())
                .password(signUpRequest.getPassword())
                .email(signUpRequest.getEmail())
                .nickname(signUpRequest.getNickname())
                .build();

    }
}
