package com.example.sbcboardweather.service;

import com.example.sbcboardweather.dto.SigninReponseDTO;
import com.example.sbcboardweather.mapper.MemberMapper;
import com.example.sbcboardweather.model.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class MemberService {

    public final MemberMapper memberMapper;

    public void signUp(Member member) {
        memberMapper.signUp(member);
    }

    public SigninReponseDTO signin(Member member, HttpSession session) {
        Member getMember = memberMapper.signIn(member.getUserId());
        if (getMember == null) {
            return SigninReponseDTO(false, "존재하지 않는 회원입니다.", null, null);
        }

        if (!member.getPassword().equals(getMember.getPassword())) {
            return SigninReponseDTO(false, "비밀번호가 틀렸습니다.", null, null);
        }

        session.setAttribute("userId", getMember.getUserId());
        session.setAttribute("userName", getMember.getUserName());

        return SigninReponseDTO(true, "로그인이 성공했습니다.", "/board", getMember);
        
    }
    
    private SigninReponseDTO SigninReponseDTO(boolean isloggedIn, String message, String url, Member member) {
        return SigninReponseDTO.builder()
                .isLoggedIn(isloggedIn)
                .message(message)
                .url(url)
                .userId(isloggedIn ? member.getUserId() : null)
                .userName(isloggedIn ? member.getUserName() : null)
                .build();
    }

}
