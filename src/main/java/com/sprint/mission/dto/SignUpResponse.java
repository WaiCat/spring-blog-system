package com.sprint.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SignUpResponse {
    private boolean success;
    private String message;
}
