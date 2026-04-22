package com.project.timetracker.statistics.dto;

import java.time.Duration;
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
public class CategoryStatisticsResponse {

    private Long categoryId;
    private String categoryName;
    private Duration totalDuration;
}
