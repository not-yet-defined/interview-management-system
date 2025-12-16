package com.flatirons.interview.interviewservice.dto;

import lombok.Data;

@Data
public class FeedbackRequestDto {
    private Integer rating;
    private String comments;
}