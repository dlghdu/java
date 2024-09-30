package org.example.tobi.sbcnotice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tobi.sbcnotice.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> somefind();

}
