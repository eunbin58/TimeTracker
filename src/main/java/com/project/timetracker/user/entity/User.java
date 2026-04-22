package com.project.timetracker.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//이 클래스는 DB 테이블과 매핑된다는 의미
//JPA가 이 객체를 보고 테이블을 자동으로 관리함
@Entity
//실제 DB 테이블 이름 지정
@Table(name = "users")
//생성/수정 시간을 자동으로 채워주는 기능,
//@CreatedDate,@LastModifiedDate를 동작시키는 기능
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
//기본 생성자 생성 (필수)
//JPA는 기본 생성자 없으면 에러남
@NoArgsConstructor
//모든 필드를 받는 생성자 생성
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    //PK
    @Id
    //DB자동 증가 (auto increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String nickname;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
