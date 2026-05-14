package com.project.timetracker.auth.controller;

import com.project.timetracker.auth.dto.AuthResponse;
import com.project.timetracker.auth.dto.LoginRequest;
import com.project.timetracker.auth.dto.SignUpRequest;
import com.project.timetracker.auth.service.AuthService;
import com.project.timetracker.common.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
//final이 붙은 필드를 생성자로 자동 주입해줘.
@RequiredArgsConstructor

public class AuthController {

    //AuthController는 AuthService를 사용한다.
    //한 번 주입되면 바뀌지 않는다.
    //final: 초기화 후 변경 불가
    private final AuthService authService;

    @PostMapping("/login")
    //ResponseEntity는 HTTP 응답 전체를 다룰 수 있는 객체
    //1. 상태 코드 (200, 400, 500 등)
    //2. 응답 body (JSON 데이터)
    //3. 헤더 (선택) 포함
    //ApiResponse<AuthResponse> : ApiResponse 안의 data 타입은 AuthResponse다.
    //ApiResponse는 내가 만든 DTO
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequest request) {

        AuthResponse response = authService.login(request);

        return ResponseEntity.ok(

                ApiResponse.<AuthResponse>builder()
                        .success(true)
                        .data(response)
                        .message("로그인 성공")
                        .build()
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<AuthResponse>> signup(@Valid @RequestBody SignUpRequest request) {
        AuthResponse response = authService.signup(request);

        return ResponseEntity.ok(
                ApiResponse.<AuthResponse>builder()
                        .success(true)
                        .data(response)
                        .message("회원가입 성공")
                        .build()
        );
    }
}
