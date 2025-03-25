package com.sprint.mission.controller;

import com.sprint.mission.dto.LoginRequest;
import com.sprint.mission.dto.LoginResponse;
import com.sprint.mission.dto.SignUpRequest;
import com.sprint.mission.dto.SignUpResponse;
import com.sprint.mission.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignUpRequest request, HttpServletRequest httpRequest) {

        SignUpResponse response = authService.signUp(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletRequest httpRequest) {

        LoginResponse response = authService.login(request);

        return ResponseEntity.ok(response);
    }
}
