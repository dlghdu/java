package org.example.tobi.springbootbasic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tobi.springbootbasic.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();
    void insertUser(User user);
}
