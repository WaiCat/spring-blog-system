package com.sprint.mission.repository;


import com.sprint.mission.dto.SignUpRequest;
import com.sprint.mission.dto.UpdateUserRequest;
import com.sprint.mission.dto.UserInfoDto;
import com.sprint.mission.entity.User;

import java.util.List;

public interface UserRepository {
    void addUser(User user);

    List<String> getAllUserIds();

    UserInfoDto getUserInfo(String userId);

    User getUser(String userId);

    void updateUser(UpdateUserRequest updateUserRequest);

    void deleteUser(String userId);

    boolean existUser(String userId);
}
