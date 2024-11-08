package org.example.tobi.springbootspringbootbasicboardtwo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tobi.springbootspringbootbasicboardtwo.model.Member;

@Mapper
public interface MemberMapper {

    void signUp(Member member);
    Member Login(String userId);
}
