package com.example.sbcboardhome.Service;

import com.example.sbcboardhome.mapper.Membermapper;
import com.example.sbcboardhome.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final Membermapper membermapper;

    public void signUp(Member member) {
        membermapper.signUp(member);
    }

}
