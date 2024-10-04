package org.example.tobi.sbcnode.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tobi.sbcnode.model.Member;

@Mapper
public interface MemberMapper {

    void signUp(Member member);
}
