package com.example.umc9th.global.auth;

import com.example.umc9th.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final Users user;

    // 권한을 List 형태로 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> user.getRole().toString());
    }

    // 비밀번호를 반환
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // 아이디를 반환(여기선 이메일)
    @Override
    public String getUsername() {
        return user.getEmail();
    }
}
