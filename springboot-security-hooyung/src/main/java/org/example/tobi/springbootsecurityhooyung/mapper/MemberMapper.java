package org.example.tobi.springbootsecurityhooyung.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tobi.springbootsecurityhooyung.model.Member;

@Mapper
public interface MemberMapper {

    void signUp(Member member);
    Member Login(String userId);
}
