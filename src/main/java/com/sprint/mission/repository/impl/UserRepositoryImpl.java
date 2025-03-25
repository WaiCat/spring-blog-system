package com.sprint.mission.repository.impl;

import com.sprint.mission.dto.UpdateUserRequest;
import com.sprint.mission.dto.UserInfoDto;
import com.sprint.mission.entity.User;
import com.sprint.mission.repository.FileStorageManager;
import com.sprint.mission.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
public class UserRepositoryImpl implements UserRepository {

    private final FileStorageManager fileStorageManager;
    private final Map<String, User> userMap;
    private final String fileName = "users.src";

    public UserRepositoryImpl(FileStorageManager fileStorageManager) {
        this.fileStorageManager = fileStorageManager;
        this.userMap = fileStorageManager.loadFile(fileName);
    }

    private void save() {
        fileStorageManager.saveFile(fileName, userMap);
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(), user);
        save();
    }

    @Override
    public List<String> getAllUserIds() {
        return new ArrayList<>(userMap.keySet());
    }

    @Override
    public UserInfoDto getUserInfo(String userId) {
        return UserInfoDto.toDto(userMap.get(userId));
    }

    @Override
    public User getUser(String userId) {
        return userMap.get(userId);
    }

    @Override
    public void updateUser(UpdateUserRequest updateUserRequest) {
        User user = userMap.get(updateUserRequest.getId());
        if (updateUserRequest.getPassword() != null) user.setPassword(updateUserRequest.getPassword());
        if (updateUserRequest.getEmail() != null) user.setEmail(updateUserRequest.getEmail());
        if (updateUserRequest.getNickname() != null) user.setNickname(updateUserRequest.getNickname());

        userMap.put(user.getId(), user);
        save();
    }

    @Override
    public void deleteUser(String userId) {
        userMap.remove(userId);
        save();
    }

    @Override
    public boolean existUser(String userId) {
        return userMap.containsKey(userId);
    }
}
