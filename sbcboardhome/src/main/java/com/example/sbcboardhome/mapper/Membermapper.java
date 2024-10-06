package com.example.sbcboardhome.mapper;

import com.example.sbcboardhome.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Membermapper {

   void signUp(Member member);

}
