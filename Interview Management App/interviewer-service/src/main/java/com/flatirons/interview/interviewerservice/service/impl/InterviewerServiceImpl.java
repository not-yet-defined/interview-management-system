package com.flatirons.interview.interviewerservice.service.impl;

import com.flatirons.interview.interviewerservice.domain.entity.Interviewer;
import com.flatirons.interview.interviewerservice.dto.InterviewerRequestDto;
import com.flatirons.interview.interviewerservice.dto.InterviewerResponseDto;
import com.flatirons.interview.interviewerservice.mapper.InterviewerMapper;
import com.flatirons.interview.interviewerservice.repository.InterviewerRepository;
import com.flatirons.interview.interviewerservice.service.InterviewerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewerServiceImpl implements InterviewerService {

    private final InterviewerRepository repository;
    private final InterviewerMapper mapper;

    public InterviewerServiceImpl(InterviewerRepository repository, InterviewerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public InterviewerResponseDto createInterviewer(InterviewerRequestDto interviewerRequestDto) {
        Interviewer saved = repository.save(mapper.toEntity(interviewerRequestDto));
        return mapper.toDto(saved);
    }

    @Override
    public InterviewerResponseDto getInterviewerById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Interviewer not found"));
    }

    @Override
    public List<InterviewerResponseDto> getAllInterviewers() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
