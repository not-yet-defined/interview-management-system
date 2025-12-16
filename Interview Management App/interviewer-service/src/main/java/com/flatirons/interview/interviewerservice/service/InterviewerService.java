package com.flatirons.interview.interviewerservice.service;

import com.flatirons.interview.interviewerservice.dto.InterviewerRequestDto;
import com.flatirons.interview.interviewerservice.dto.InterviewerResponseDto;

import java.util.List;

public interface InterviewerService {

    InterviewerResponseDto createInterviewer(InterviewerRequestDto dto);

    InterviewerResponseDto getInterviewerById(Long id);

    List<InterviewerResponseDto> getAllInterviewers();
}
