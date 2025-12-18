package com.example.umc9th.domain.users.service.query;

import com.example.umc9th.domain.users.converter.UserConverter;
import com.example.umc9th.domain.users.dto.req.UserReqDTO;
import com.example.umc9th.domain.users.dto.res.UserResDTO;
import com.example.umc9th.domain.users.entity.Users;
import com.example.umc9th.domain.users.exception.UserException;
import com.example.umc9th.domain.users.exception.code.UserErrorCode;
import com.example.umc9th.domain.users.repository.UsersRepository;
import com.example.umc9th.global.auth.CustomUserDetails;
import com.example.umc9th.global.auth.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService{


    private final UsersRepository usersRepository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    @Override
    public UserResDTO.LoginDTO login(UserReqDTO.LoginDTO dto) {

        // User 조회
        Users user = usersRepository.findByEmail(dto.email())
                .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));

        // 비밀번호 검증
        if (!encoder.matches(dto.password(), user.getPassword())) {
            throw new UserException(UserErrorCode.INVALID);
        }

        // JWT 토큰 발급용 UserDetails
        CustomUserDetails userDetails = new CustomUserDetails(user);

        // 액세스 토큰 발급
        String accessToken = jwtUtil.createAccessToken(userDetails);

        // DTO 조립
        return UserConverter.toLoginDTO(user, accessToken);
    }
}
