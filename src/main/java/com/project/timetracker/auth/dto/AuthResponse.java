package com.project.timetracker.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    //JWT 토큰 (로그인 후 인증용)
    private String accessToken;
    /*
    tokenType:
    Bearer:토큰을 들고 있는 사람이 인증된 사용자로 인정됨(토큰 기반 인증)
    basic:아이디+비밀번호를 그대로 보내는 방식 (base64인코딩)
    API key(외부 API, 사용자 인증보단 서비스 인증시 사용)
    OAuth(방식X,프로토콜=>OAuth도 결국 Bearer 토큰 사용함,카카오로그인 등)

     */
    private String tokenType;
    private Long userId;
    private String email;
    private String name;
}
