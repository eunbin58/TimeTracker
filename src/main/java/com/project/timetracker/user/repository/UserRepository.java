package com.project.timetracker.user.repository;

import com.project.timetracker.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*jpaRepository가 이미 제공하는 것들
save(user)        // insert or update
findById(id)      // select
findAll()         // 전체 조회
delete(user)      // 삭제


UserRepository = 사용자 테이블 접근 전용 객체
JpaRepository<User, Long>
User → 어떤 테이블(Entity)을 다루는지
Long → PK 타입

"User 테이블을 Long PK 기준으로 다루는 JPA 기본 기능을 상속받겠다"
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /*
    Optional, List, boolean 반환 타입
    Optional<T>
    하나 나올 수도 있고 없을 수도 있을 때
    List<T>
   여러 건 조회할 때
   boolean
   존재 여부만 필요할 때
     */

    //이메일로 사용자 조회
    //SELECT * FROM users WHERE email = ?
    Optional<User> findByEmail(String email);

    //이메일 존재 여부 확인
    //SELECT COUNT(*) > 0 FROM users WHERE email = ?
    boolean existsByEmail(String email);
}
