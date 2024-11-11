package org.example.tobi.springbootspringbootbasicboardtwo.Service;

import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootspringbootbasicboardtwo.config.security.CustomUserDetails;
import org.example.tobi.springbootspringbootbasicboardtwo.mapper.MemberMapper;
import org.example.tobi.springbootspringbootbasicboardtwo.model.Member;
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
