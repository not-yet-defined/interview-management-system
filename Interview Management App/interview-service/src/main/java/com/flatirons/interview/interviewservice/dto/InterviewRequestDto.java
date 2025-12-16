package com.flatirons.interview.interviewservice.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class InterviewRequestDto {
    private Long candidateId;
    private Long interviewerId;
    private LocalDateTime scheduledAt;
}