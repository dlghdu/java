package com.example.springbootsecurityhoyoung.Service;

import com.example.springbootsecurityhoyoung.config.security.CustomUserDetails;
import com.example.springbootsecurityhoyoung.mapper.MemberMapper;
import com.example.springbootsecurityhoyoung.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberMapper.findByUserId(username);
        System.out.println("CustomUserDetails " + member);
        if (member == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return CustomUserDetails.builder()
                .member(member)
                .roles(
                        List.of(String.valueOf(member.getRole()))
                )
                .build();
    }
}