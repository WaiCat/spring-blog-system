package com.sprint.mission.dto;

import com.sprint.mission.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserInfoDto {
    private String id;
    private String email;
    private String nickname;

    public static UserInfoDto toDto(User user){
        return UserInfoDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .build();
    }
}
