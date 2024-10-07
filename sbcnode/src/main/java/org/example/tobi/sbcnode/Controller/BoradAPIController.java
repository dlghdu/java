package org.example.tobi.sbcnode.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.tobi.sbcnode.Service.BoardService;
import org.example.tobi.sbcnode.Service.MemberService;
import org.example.tobi.sbcnode.dto.LoginRequestDTO;
import org.example.tobi.sbcnode.dto.LoginResponseDTO;
import org.example.tobi.sbcnode.dto.SignupRequestDTO;
import org.example.tobi.sbcnode.dto.SignupResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoradAPIController {

    private final BoardService boardService;

}
