# TimeTracker Backend

사용자의 시간 기록 데이터를 저장하고, 기본 통계를 제공하는 Spring Boot 기반 타임 트래킹 백엔드 서비스입니다.

---

## 프로젝트 개요

이 프로젝트의 1차 목표는 AI 추천이나 분석 기능까지 한 번에 구현하는 것이 아니라,
다음과 같은 핵심 백엔드 기능을 안정적으로 완성하는 것입니다.

* 사용자 인증
* 카테고리 관리
* 시간 기록 시작/종료
* 실행 중 타이머 조회
* 일별/주간/카테고리별 통계 조회

즉, 1차에서는 “행동 개선 분석”보다 “데이터를 안정적으로 기록하고 확인하는 것”에 집중합니다.

---

## 1차 범위

### 포함 기능

* 회원가입
* 로그인
* 사용자 인증 처리
* 카테고리 생성 / 조회 / 수정 / 삭제
* 타이머 시작
* 타이머 종료
* 실행 중 타이머 조회
* 기록 조회
* 일별 총 시간 조회
* 주간 총 시간 조회
* 카테고리별 시간 집계

### 제외 기능

* 집중도 입력
* 낭비 시간 분석
* 추천 시스템
* LLM 리포트 생성
* 군집 분석

---

## 기술 스택

* Java
* Spring Boot
* JPA (Hibernate)
* PostgreSQL
* JWT
* Swagger / OpenAPI
* Gradle

---

## 패키지 구조

com.project.timetracker
├── auth
├── user
├── category
├── record
├── timer
├── statistics
├── common
├── config
└── security

---

## 아키텍처 개요

Client
↓
Spring Boot API Server
↓
PostgreSQL

---

## 계층 구조

* Controller: 요청/응답 처리
* Service: 비즈니스 로직 처리
* Repository: DB 접근
* Entity: 테이블 매핑
* DTO: API 요청/응답 데이터 전달

---

## 핵심 비즈니스 규칙

* 사용자당 실행 중인 타이머는 1개만 허용합니다.
* 실행 중 타이머가 있으면 새 타이머 시작이 불가능합니다.
* 실행 중 타이머가 없으면 종료할 수 없습니다.
* 사용자 데이터는 인증된 사용자 기준으로만 조회합니다.
* status는 enum으로 관리합니다.
* DTO와 Entity는 분리합니다.
* FK 관계는 JPA 연관관계로 매핑합니다.

---

## 주요 API

### 인증

* POST /api/auth/signup
* POST /api/auth/login

### 사용자

* GET /api/users/me

### 카테고리

* POST /api/categories
* GET /api/categories
* PATCH /api/categories/{id}
* DELETE /api/categories/{id}

### 타이머

* POST /api/timers/start
* GET /api/timers/current
* POST /api/timers/stop

### 기록

* GET /api/records?date=YYYY-MM-DD

### 통계

* GET /api/statistics/daily
* GET /api/statistics/weekly
* GET /api/statistics/categories

---

## 문서 구조

* AGENTS.md → 작업 규칙 및 Codex 가이드
* docs/REQUIREMENTS.md → 요구사항 정의
* docs/WORKLOG.md → 작업 기록
* docs/TROUBLESHOOTING.md → 문제 해결 기록
* docs/BACKLOG.md → 리팩토링 및 확장 후보

---

## 실행 전 체크

* PostgreSQL 실행 여부
* DB 생성 여부
* application.yml 또는 환경변수 설정 여부
* JWT secret 설정 여부

---

## 현재 목표

1차 MVP 완성

* 인증
* 시간 기록
* 카테고리 관리
* 통계 조회
* 예외 처리
* Swagger 문서화
