package com.example.sbcboardweather.mapper;

import com.example.sbcboardweather.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void signUp(Member member);
    Member signIn(String userId);

}
