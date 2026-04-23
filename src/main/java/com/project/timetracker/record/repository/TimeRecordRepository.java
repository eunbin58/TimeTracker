package com.project.timetracker.record.repository;

import com.project.timetracker.record.RecordStatus;
import com.project.timetracker.record.entity.TimeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {

    List<TimeRecord> findByUserId(Long userId);

    //실행중인 타이머가 있는지 확인
    Optional<TimeRecord> findByUserIdAndStatus(Long userId, RecordStatus status);
}
