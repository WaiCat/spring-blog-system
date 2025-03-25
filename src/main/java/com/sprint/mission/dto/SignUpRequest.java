package com.sprint.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpRequest {
    private String id;
    private String password;
    private String email;
    private String nickname;
}
