package com.sprint.mission.service;

import com.sprint.mission.dto.SignUpRequest;
import com.sprint.mission.dto.UpdateUserRequest;
import com.sprint.mission.dto.UserInfoDto;
import com.sprint.mission.entity.User;

import java.util.List;

public interface UserService {

    UserInfoDto getUserInfoById(String id);
    List<String> getAllUserIds();
    void updateUser(UpdateUserRequest request);
    void deleteUser(String id);
    boolean existsById(String id);
}
