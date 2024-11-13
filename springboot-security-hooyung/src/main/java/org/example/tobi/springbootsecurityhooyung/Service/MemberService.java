package org.example.tobi.springbootsecurityhooyung.Service;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootsecurityhooyung.dto.LoginResponseDTO;
import org.example.tobi.springbootsecurityhooyung.mapper.MemberMapper;
import org.example.tobi.springbootsecurityhooyung.model.Member;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public void signUp(Member member) {
        memberMapper.signUp(member);
    }

    public LoginResponseDTO signIn(Member member, HttpSession session) {
        Member getMember = memberMapper.Login(member.getUserId());
        if (getMember == null) {
            return makeSignInRequestDTO(false, "존재하지 않는 회원입니다.", null, null);
        }

        if ( !member.getPassword().equals(getMember.getPassword()) ) {
            return makeSignInRequestDTO(false, "비밀번호가 틀렸습니다.", null, null);
        }

        // 세션 설정
        session.setAttribute("userId", getMember.getUserId());
        session.setAttribute("userName", getMember.getUserName());

        return makeSignInRequestDTO(true, "로그인이 성공했습니다.", "/", member);
    }


    private LoginResponseDTO makeSignInRequestDTO(boolean isloggedIn, String message, String url, Member member) {
        return LoginResponseDTO.builder()
                .isLoggedIn(isloggedIn)
                .message(message)
                .url(url)
                .userId(isloggedIn ? member.getUserId() : null)
                .userName(isloggedIn ? member.getUserName() : null)
                .build();
    }

}