package com.sprint.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateUserRequest {
    private String id;
    private String password;
    private String email;
    private String nickname;
}
