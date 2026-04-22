package com.project.timetracker.timer.dto;

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
public class CurrentTimerResponse {

    private boolean running;
    private Long categoryId;
    private LocalDateTime startedAt;
}
