package com.sprint.mission.service.Impl;

import com.sprint.mission.dto.SignUpRequest;
import com.sprint.mission.dto.UpdateUserRequest;
import com.sprint.mission.dto.UserInfoDto;
import com.sprint.mission.repository.UserRepository;
import com.sprint.mission.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserInfoDto getUserInfoById(String id) {
        return userRepository.getUserInfo(id);
    }

    @Override
    public List<String> getAllUserIds() {
        return userRepository.getAllUserIds();
    }

    @Override
    public void updateUser(UpdateUserRequest request) {
        userRepository.updateUser(request);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteUser(id);
    }

    @Override
    public boolean existsById(String id) {
        return userRepository.existUser(id);
    }
}
