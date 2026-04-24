# AGENTS.md

## 프로젝트 목적
- 1차 목표는 Spring Boot 타임트래커 MVP 완성
- 구조 완벽화보다 동작하는 기능 완성을 우선한다

## 현재 우선순위
1. 회원가입 / 로그인
2. 카테고리 CRUD
3. 타이머 시작 / 종료 / 실행 중 조회
4. 기록 조회
5. 일별 / 주간 / 카테고리 통계

## 지금 당장 지킬 것
- 패키지 구조 유지
- DTO와 Entity 분리
- FK 관계는 JPA 연관관계로 매핑
- status는 enum 사용

## 구현 원칙
- 지금은 1차 MVP 완성을 우선
- 큰 리팩토링이 아니면 일단 구현 후 개선
- 질문 답변 시 "지금 수정" / "나중에 수정" 판단 포함

## 기술 스택
- Java
- Spring Boot
- JPA(Hibernate)
- PostgreSQL
- Gradle
- JWT

## 도메인 패키지
- auth
- user
- category
- record
- statistics
- common
- config
- security

## documents 위치
- 요구사항: `docs/REQUIREMENTS.md`
- 작업 기록: `docs/WORKLOG.md`
- 문제 해결 기록: `docs/TROUBLESHOOTING.md`
- 백로그: `docs/BACKLOG.md`

## 문서 규칙
- 기능 단위 완료 또는 하루 종료 시 WORKLOG.md 업데이트
- 문제 해결 시 TROUBLESHOOTING.md 기록
- 리팩토링 후보는 BACKLOG.md에 기록

## 파일 읽기 규칙
- PowerShell에서 한글 주석/문서가 포함된 파일을 읽을 때는 `Get-Content -Encoding UTF8`을 사용한다.
- 예: `Get-Content -Path docs/BACKLOG.md -Encoding UTF8`

## 판단 기준
- DB 구조, API 구조 영향 → 지금 수정
- 구조 개선 성격 → 나중에 리팩토링
- 학습/속도 저해 → 일단 구현 후 개선
- 중복 코드 발생 → BACKLOG.md 기록 후 진행

## 작업 흐름
1. REQUIREMENTS.md 기준으로 작업 범위 확인
2. 해당 기능 설계 (Entity → Repository → Service → Controller 순)
3. API 단위로 구현 및 테스트
4. 예외 케이스 처리
5. 기능 완료 후 WORKLOG.md 업데이트

## 범위 제한
- REQUIREMENTS.md에 없는 기능은 구현하지 않는다
- AI / 추천 / 분석 기능은 1차에서 제외
- 새로운 기능 추가 시 반드시 필요 여부를 먼저 판단한다
- 
## 예외 처리 기준
- 사용자 입력 오류 → 400
- 인증 실패 → 401
- 권한 문제 → 403
- 리소스 없음 → 404
- 서버 오류 → 500
