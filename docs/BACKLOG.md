# BACKLOG

현재 바로 구현하지는 않지만, 이후 작업 후보로 남겨두는 문서입니다.  
리팩토링 후보, 확장 기능, 기술 부채, 문서 보완 항목을 함께 관리합니다.

---

## 1. 사용 규칙

- 지금 당장 필요한 작업이 아니면 여기에 기록한다.
- 완료된 항목은 삭제하지 말고 상태를 변경한다.
- 구현 범위를 흔드는 아이디어는 먼저 REQUIREMENTS와 비교한다.
- 단순 메모가 아니라 “왜 필요한지”까지 짧게 적는다.

---

## 2. 상태 기준

- `todo` : 아직 안 함
- `doing` : 진행 중
- `done` : 완료
- `hold` : 보류
- `drop` : 하지 않기로 함

---

## 3. 우선순위 기준

- `high` : 빠른 시점에 반영 필요
- `medium` : 여유 있을 때 반영
- `low` : 장기 후보

---

## 4. 리팩토링 후보

| ID | 항목 | 이유 | 우선순위 | 상태 | 비고 |
|---|---|---|---|---|---|
| R-001 | 전체 setter 제거 검토 | 객체 무분별한 변경 방지 | medium | todo | MVP 이후 검토 |
| R-002 | builder 범위 정리 | 생성 규칙 명확화 | low | todo | 엔티티 정리 후 |
| R-003 | 생성자 접근 제어 정교화 | 도메인 무결성 강화 | medium | todo | |
| R-004 | 예외 클래스 세분화 | 에러 처리 가독성 향상 | medium | todo | |
| R-005 | 공통 응답 포맷 정리 | 응답 일관성 확보 | medium | todo | |
| R-006 | 테스트 코드 보강 | 회귀 방지 | high | todo | 핵심 API 우선 |
| R-007 | Category soft delete 조회 조건 정리 | 삭제된 카테고리가 목록/통계에 포함되지 않도록 Repository 조회 조건 필요 | medium | todo | `findByUserIdAndDeletedFalse` 등 서비스 구현 시 반영 |
| R-008 | TimeRecord duration 저장 방식 검토 | 통계 쿼리 단순화를 위해 `Duration` 대신 초 단위 숫자 저장 검토 | medium | todo | `durationSeconds` 후보, 통계 구현 전 결정 |
| R-009 | Category boolean 필드명 정리 | `isDeleted` 필드명은 Lombok/JPA/JSON 매핑에서 혼동 가능 | low | todo | `deleted`로 변경 후보 |
| R-010 | 엔티티 필수값 nullable 정책 보강 | 이름, 시작 시간 등 도메인 필수값을 DB 제약과 맞출 필요 | medium | todo | `Category.name`, `TimeRecord.startTime` 등 |
| R-011 | Repository 메서드 네이밍 기준 정리 | `findByUserId`, `findAllByUserId`, `findByUser_Id`처럼 같은 목적의 표현이 섞일 수 있어 기준 필요 | low | todo | MVP 구현 후 Repository 전반 정리 |
| R-012 | TimeRecord 날짜 범위 조회 추가 검토 | 기록 조회/일별/주간 통계 구현 시 `startTime` 기준 기간 조회가 필요할 가능성 있음 | medium | todo | Service 구현 중 실제 필요할 때 추가 |
| R-013 | Category 이름 중복 정책 검토 | 같은 사용자가 동일한 카테고리 이름을 여러 개 만들 수 있는지 정책 결정 필요 | medium | todo | 카테고리 CRUD 구현 안정화 후 결정 |

---

## 5. 기능 확장 후보

| ID | 항목 | 이유 | 우선순위 | 상태 | 비고 |
|---|---|---|---|---|---|
| F-001 | 집중도 입력 | 2차 기능 | low | hold | 1차 제외 |
| F-002 | 낭비 시간 분석 | 2차 기능 | low | hold | 데이터 축적 후 |
| F-003 | 추천 시스템 | 2차 기능 | low | hold | |
| F-004 | LLM 리포트 | 3차 기능 | low | hold | |
| F-005 | 군집 분석 | 고도화 기능 | low | hold | |

---

## 6. 문서 보완 후보

| ID | 항목 | 이유 | 우선순위 | 상태 | 비고 |
|---|---|---|---|---|---|
| D-001 | Swagger 사용 예시 보완 | API 확인 편의성 향상 | medium | todo | |
| D-002 | ERD 최신화 | 설계 문서 일치 | medium | todo | |
| D-003 | 실행 가이드 상세화 | 협업/재현성 향상 | medium | todo | README 반영 |

---

## 7. 메모

- 새 항목 추가 시 REQUIREMENTS 범위를 먼저 확인한다.
- 지금 꼭 필요한 수정이면 WORKLOG가 아니라 바로 작업 대상으로 옮긴다.
- 장기 보류 항목은 hold로 둔다.
