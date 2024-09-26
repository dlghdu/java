package org.example.tobi.spring_tobi.ch5.ex_5_1.dao;

import org.example.tobi.spring_tobi.ch5.ex_5_1.domain.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void deleteAll();
    List<User> getAll();
    User get(String id);
    int getCount();
    void update(User user);
}