package com.project.timetracker.category.repository;

import com.project.timetracker.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    //소프트 삭제를 하기때문에 조회를 이렇게 해야함
    List<Category> findAllByUserIdAndIsDeletedFalse(Long userId);

    //이미 들어갈때 IsDeletedFalse를 하기 때문에 인자를 받을 필요가 없음, 외부에서 받으려면 다음과 같이 작성
    //List<Category> findAllByUserIdAndIsDeleted(Long userId, boolean isDeleted);

    //기본 조회
    //List<Category> findByUserId(Long userId);

    //사용자별 카테고리 findByUserId와 중복
    //List<Category> findAllByUserId(Long userId);
}
