package org.example.tobi.sbcnode.Service;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.tobi.sbcnode.dto.LoginResponseDTO;
import org.example.tobi.sbcnode.mapper.MemberMapper;
import org.example.tobi.sbcnode.model.Member;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper mbmp;

    public void signUp(Member member) {
        mbmp.signUp(member);
    }

    public LoginResponseDTO login(Member member, HttpSession session) {
        Member getMember = mbmp.Login(member.getUserId());
        if (getMember == null) {
            return makeLoginResponseDTO(false, "존재하지 않는 회원입니다.", null, null);
        }

        if (!member.getPassword().equals(getMember.getPassword())) {
            return makeLoginResponseDTO(false, "비밀번호가 틀렸습니다.", null, null);
        }

        // 세션 설정
        session.setAttribute("userId", getMember.getUserId());
        session.setAttribute("userName", getMember.getUserName());

        return makeLoginResponseDTO(true, "로그인이 성공했습니다.", "/", member);
    }

    private LoginResponseDTO makeLoginResponseDTO(boolean isloggedIn, String message, String url, Member member) {
        return LoginResponseDTO.builder()
                .isLoggedIn(isloggedIn)
                .message(message)
                .url(url)
                .userId(isloggedIn ? member.getUserId() : null)
                .userName(isloggedIn ? member.getUserName() : null)
                .build();
    }

}