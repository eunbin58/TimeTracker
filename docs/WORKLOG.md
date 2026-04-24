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

