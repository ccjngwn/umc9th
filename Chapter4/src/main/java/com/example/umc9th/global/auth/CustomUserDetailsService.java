package com.example.umc9th.global.auth;

import com.example.umc9th.domain.users.entity.Users;
import com.example.umc9th.domain.users.exception.UserException;
import com.example.umc9th.domain.users.exception.code.UserErrorCode;
import com.example.umc9th.domain.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 검증할 유저 조회
        Users user = usersRepository.findByEmail(username)
                .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));

        // CustomUserDetails 반환
        return new CustomUserDetails(user);
    }
}
