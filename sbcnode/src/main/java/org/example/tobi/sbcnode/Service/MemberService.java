package org.example.tobi.sbcnode.Service;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.tobi.sbcnode.mapper.MemberMapper;
import org.example.tobi.sbcnode.model.Member;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

//    private final MemberMapper memberMapper;
//
//    public void signUp(Member member) {
//        memberMapper.signUp(member);
//    }

    private final MemberMapper mbmp;

    public void Signup(Member member) {
        mbmp.Signup(member);
    }


}