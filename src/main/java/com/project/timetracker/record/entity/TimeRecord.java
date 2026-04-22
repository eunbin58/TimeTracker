package com.project.timetracker.record.entity;

import com.project.timetracker.category.entity.Category;
import com.project.timetracker.record.RecordStatus;
import com.project.timetracker.user.entity.User;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "time_records")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class TimeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Duration duration;

    //enum: 정해진 값만 들어가도록 제한
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecordStatus status;
    //RecordStatus 등에 다음을 넣어야함
    /*
    public enum RecordStatus {
    RUNNING,
    COMPLETED,
    CANCELLED
}
     */

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
