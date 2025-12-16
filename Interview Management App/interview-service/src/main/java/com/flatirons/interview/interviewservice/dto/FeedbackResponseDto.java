package com.flatirons.interview.interviewservice.dto;

import lombok.Data;

@Data
public class FeedbackResponseDto {
    private Long id;
    private Long interviewId;
    private Integer rating;
    private String comments;
}