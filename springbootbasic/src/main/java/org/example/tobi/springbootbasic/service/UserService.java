package org.example.tobi.springbootbasic.service;

import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootbasic.dto.MemberResponseDTO;
import org.example.tobi.springbootbasic.mapper.UserMapper;
import org.example.tobi.springbootbasic.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<MemberResponseDTO> findAll() {
        List<User> users = userMapper.findAll();

        // 방법.1
        List<MemberResponseDTO> members = new ArrayList<>();
        for (User user : users) {
            members.add(user.toMemberResponseDTO());
        }
        return members;

        // 방법2 : Java Stream & Lambda
//        return users.stream()
//                .map(User::toMemberResponseDTO)
//                .collect(Collectors.toList());
    }

    public MemberResponseDTO findById(Long id) {
        return userMapper.findById(id)
                .toMemberResponseDTO();
    }

    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }
}
