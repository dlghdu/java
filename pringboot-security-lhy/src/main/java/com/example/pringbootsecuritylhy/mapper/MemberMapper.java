package com.example.pringbootsecuritylhy.mapper;


import com.example.pringbootsecuritylhy.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void signUp(Member member);
    Member findByUserId(String userId);
}
