# WORKLOG

---

## 2026-04-22

### 완료
- User Entity 작성

### 진행 중
- TimeRecord Entity 작성

### 다음 작업
- Category Entity 작성

### 이슈 / 고민
- setter 제거 vs 유지 고민
- enum 적용 타이밍 고민

---

## 2026-04-23

### 완료
- UserRepository 작성
- TimeRecordRepository 작성
- CategoryRepository 작성
- Repository 코드 리뷰 진행
- Repository 관련 리팩토링 후보를 BACKLOG.md에 기록
- PowerShell에서 한글 주석/문서 파일을 읽을 때 `Get-Content -Encoding UTF8`을 사용하도록 AGENTS.md에 규칙 추가

### 다음 작업
- auth 작업

### 이슈 / 고민
- 인덱스 추가 타이밍 고민
- Repository 조회 메서드는 Service 구현 중 실제 필요해질 때 추가하는 방향으로 진행
- TimeRecord 실행 중 조회는 존재 여부만 필요한지, 실제 TimeRecord 조회가 필요한지 Service 구현 시 결정 필요
- Category 이름 중복 허용 여부는 카테고리 CRUD 구현 안정화 후 결정

---

## 2026-05-14

### 완료
- `AuthService` 로그인 로직 구현 완료
- `AuthService` 회원가입 로직 구현 완료
- `GlobalExceptionHandler`에 `BadCredentialsException` 처리 추가
- 회원가입 중복 이메일 처리용 예외 클래스 추가 및 글로벌 예외 처리 연결

### 학습 / 이해한 내용
- 비밀번호 검증 시 `.equals()`로 비교하면 안 된다는 점을 이해함
- `.equals()`는 단순 문자열 비교이기 때문에 암호화된 비밀번호 검증 방식에 맞지 않음
- `passwordEncoder.matches(rawPassword, encodedPassword)`는 사용자가 입력한 평문 비밀번호와 DB에 저장된 암호화 비밀번호가 일치하는지 확인하는 방식임
- 글로벌 예외 처리 구조에서는 커스텀 예외를 만들 때 `extends Throwable`보다 `extends RuntimeException`을 사용하는 편이 적절하다는 점을 학습함
- `checked exception`은 처리 강제가 생기지만, 현재 프로젝트는 `GlobalExceptionHandler`에서 공통 처리하므로 `RuntimeException` 기반이 더 실용적이라는 점을 이해함
- 인증/회원가입처럼 같은 auth 도메인 안에서도 실패 원인에 따라 예외를 분리할 수 있다는 점을 이해함

### 다음 작업
- JWT 인증 로직 구현
- JWT 인증 필터 연결
- 로그인 후 받은 토큰으로 보호 API 1개 호출 성공까지 확인

### 이슈 / 고민
- 로그인 실패 메시지를 지금은 실행 확인용으로 구분해서 두고 있지만, MVP 마무리 시점에 운영용 메시지로 통일할지 정리 필요
- 회원가입 후 `login()`을 다시 호출해서 응답을 만드는 현재 방식은 MVP 기준에서는 괜찮지만, 이후 공통 응답 생성 구조로 정리할지 고민
- 회원가입 중복 체크를 사전 조회와 DB 예외 처리 두 단계로 가져가는 현재 방식은 안전하지만, 이후 더 단순하게 정리할지 검토 필요
