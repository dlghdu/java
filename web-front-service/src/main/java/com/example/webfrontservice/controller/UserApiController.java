package com.example.webfrontservice.controller;

import com.example.webfrontservice.dto.JoinClientResponseDTO;
import com.example.webfrontservice.dto.JoinRequestDTO;
import com.example.webfrontservice.dto.JoinResponseDTO;
import com.example.webfrontservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<JoinResponseDTO> join(@RequestBody JoinRequestDTO joinRequestDTO) {
        System.out.println("join: {}(!!)" + joinRequestDTO);
        JoinClientResponseDTO joined = userService.join(joinRequestDTO);
        return ResponseEntity.ok(joined.tojoinResponseDTO());
    }

}