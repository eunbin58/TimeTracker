package com.project.timetracker.auth.service;

import com.project.timetracker.auth.dto.AuthResponse;
import com.project.timetracker.auth.dto.LoginRequest;
import com.project.timetracker.auth.dto.SignUpRequest;
import com.project.timetracker.common.exception.EmailAlreadyExistsException;
import com.project.timetracker.security.JwtProvider;
import com.project.timetracker.user.entity.User;
import com.project.timetracker.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    //토큰 생성 담당 객체
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    //@Transactional: 이 메서드 작업을 하나의 DB 작업 단위로 관리
    //(readOnly = true): 읽기 작업만 허용
    @Transactional(readOnly = true)
    //로그인 요청을 받아서
    //로그인 결과(AuthResponse)를 반환
    //LoginRequest 타입의 데이터를
    //request라는 이름으로 받겠다

    public AuthResponse login(LoginRequest request) {
        // TODO: 이메일로 사용자 조회
        User user = userRepository.findByEmail(request.getEmail())
                //.orElseThrow(...): if(user == null) 사용자가 없으면 예외 발생
                .orElseThrow(() -> new BadCredentialsException("존재하지 않는 사용자입니다."));

        // TODO: 비밀번호 검증
        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        //JWT 토큰 생성
        //String.valueOf():숫자를 문자열(String)로 변환하는 메서드
        String accessToken = jwtProvider.createToken(String.valueOf(user.getId()));

        // TODO: 로그인 성공 응답 생성
        return AuthResponse.builder()
                .accessToken(accessToken)
                .tokenType("Bearer")
                .userId(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }

    @Transactional
    public AuthResponse signup(SignUpRequest request) {
        //이메일로 사용자 조회
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException("이미 존재하는 이메일입니다.");
        }
        User user=User.builder()
                .email(request.getEmail())
                //password 암호화
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .build();
        //동시 요청 문제 방지
        try {
            userRepository.save(user);

        } catch (DataIntegrityViolationException e) {

            throw new EmailAlreadyExistsException("이미 존재하는 이메일입니다.");
        }
        //자동 로그인
        return login(new LoginRequest(request.getEmail(), request.getPassword()));
    }
}
