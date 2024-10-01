package org.example.tobi.sbcnotice.service;

import lombok.RequiredArgsConstructor;
import org.example.tobi.sbcnotice.dto.MemberResponseDTO;
import org.example.tobi.sbcnotice.mapper.UserMapper;
import org.example.tobi.sbcnotice.model.noticee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<MemberResponseDTO> somefind() {
        List<noticee> users = userMapper.somefind();

        List<MemberResponseDTO> mudtos = new ArrayList<>();
        for (noticee user : users) {
            mudtos.add(user.toMemberResponceDTO());
        }
        return mudtos;
    }

    public void createUser(noticee user) {
        userMapper.insertUser(user);
    }

}
