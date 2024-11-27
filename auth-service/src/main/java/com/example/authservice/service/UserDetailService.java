package com.example.authservice.service;

import com.example.authservice.mapper.UserMapper;
import com.example.authservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userByUserId = userMapper.findUserByUserId(username);

        if (userByUserId == null) {
            throw new UsernameNotFoundException(username+ " not found");
        }

        return null;
    }
}
