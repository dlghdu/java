package com.example.springbootsecurityhoyoung.mapper;

import com.example.springbootsecurityhoyoung.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void signUp(Member member);
    Member Login(String userId);
}
