package com.project.timetracker.record.dto;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordResponse {

    private Long id;
    private Long categoryId;
    private String categoryName;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private Duration duration;
}
