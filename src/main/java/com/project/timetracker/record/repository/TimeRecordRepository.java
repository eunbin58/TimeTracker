package com.project.timetracker.record.repository;

import com.project.timetracker.record.entity.TimeRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {

    List<TimeRecord> findByUserId(Long userId);
}
