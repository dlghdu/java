package org.example.tobi.springbootbasic.service;

import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootbasic.dto.MemberResponseDTO;
import org.example.tobi.springbootbasic.mapper.UserMapper;
import org.example.tobi.springbootbasic.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
//                .map(User::toMemberListResponseDTO)
//                .collect(Collectors.toList());
    }

    public MemberResponseDTO findById(Long id) {
        return userMapper.findById(id)
                .toMemberResponseDTO();
    }

    public void createUser(User user) {
        userMapper.insertUser(user);
    }

<<<<<<< HEAD
    @Transactional
    public void updateUser(Long id, User user) {
        user.setId(id);
=======
//    @Transactional
//    public void updateUser(Long id, User user) {
//        user.setId(id);
//        userMapper.updateUser(user);
//    }

    public void updateUser(User user) {
>>>>>>> e4bcb4abe283200c8edc9189beaeb8e39fb701c3
        userMapper.updateUser(user);
    }

    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }
}
