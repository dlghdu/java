package com.example.authservice.service;

import com.example.authservice.config.sercurity.CustomUserDetails;
import com.example.authservice.dto.UserJoinRequestDTO;
import com.example.authservice.dto.UserJoinResponseDTO;
import com.example.authservice.dto.UserLoginResponseDTO;
import com.example.authservice.mapper.UserMapper;
import com.example.authservice.model.User;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final TokenProviderService tokenProviderService;

    public UserLoginResponseDTO login(String username, String password) {

        // 사용자 인증
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        User user = ((CustomUserDetails) authenticate.getPrincipal()).getUser();

        String accessToken = tokenProviderService.generateToken(user, Duration.ofHours(2));
        String refreshToken = tokenProviderService.generateToken(user, Duration.ofDays(2));

        return UserLoginResponseDTO.builder()
                .loggedIn(true)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getUserId())
                .userName(user.getUserName())
                .build();
    }

    public UserJoinResponseDTO join(User user) {
        return userMapper.saveUser(user) == 1 ?
                UserJoinResponseDTO.builder()
                        .isSuccess(true)
                        .build():
                UserJoinResponseDTO.builder()
                        .isSuccess(false)
                        .build();

    }

}
