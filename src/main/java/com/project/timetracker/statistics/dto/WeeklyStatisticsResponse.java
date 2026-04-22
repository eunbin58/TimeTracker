package com.project.timetracker.statistics.dto;

import java.time.Duration;
import java.time.LocalDate;
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
public class WeeklyStatisticsResponse {

    private LocalDate weekStartDate;
    private LocalDate weekEndDate;
    private Duration totalDuration;
}
