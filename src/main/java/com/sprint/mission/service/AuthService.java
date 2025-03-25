package com.sprint.mission.service;

import com.sprint.mission.dto.LoginRequest;
import com.sprint.mission.dto.LoginResponse;
import com.sprint.mission.dto.SignUpRequest;
import com.sprint.mission.dto.SignUpResponse;
import com.sprint.mission.entity.User;

public interface AuthService {

    SignUpResponse signUp(SignUpRequest signUpRequest);

    LoginResponse login(LoginRequest loginRequest);

}
