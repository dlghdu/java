package org.example.tobi.sbcnotice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tobi.sbcnotice.model.noticee;

import java.util.List;

@Mapper
public interface UserMapper {

    List<noticee> somefind();
    void insertUser(noticee notice);

}
