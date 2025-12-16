package com.flatirons.interview.interviewservice.service;

import com.flatirons.interview.interviewservice.dto.FeedbackRequestDto;
import com.flatirons.interview.interviewservice.dto.InterviewRequestDto;
import com.flatirons.interview.interviewservice.dto.InterviewResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InterviewService {

    InterviewResponseDto scheduleInterview(InterviewRequestDto dto);

    void submitFeedback(Long interviewId, FeedbackRequestDto dto);

    Page<InterviewResponseDto> search(Long candidateId,
                                      Long interviewerId,
                                      Pageable pageable);
}