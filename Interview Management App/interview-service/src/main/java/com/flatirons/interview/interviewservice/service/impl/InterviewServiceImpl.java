package com.flatirons.interview.interviewservice.service.impl;

import com.flatirons.interview.interviewservice.client.CandidateClient;
import com.flatirons.interview.interviewservice.client.InterviewerClient;
import com.flatirons.interview.interviewservice.client.NotificationClient;
import com.flatirons.interview.interviewservice.domain.entity.Feedback;
import com.flatirons.interview.interviewservice.domain.entity.Interview;
import com.flatirons.interview.interviewservice.dto.FeedbackRequestDto;
import com.flatirons.interview.interviewservice.dto.InterviewRequestDto;
import com.flatirons.interview.interviewservice.dto.InterviewResponseDto;
import com.flatirons.interview.interviewservice.mapper.FeedbackMapper;
import com.flatirons.interview.interviewservice.mapper.InterviewMapper;
import com.flatirons.interview.interviewservice.repository.FeedbackRepository;
import com.flatirons.interview.interviewservice.repository.InterviewRepository;
import com.flatirons.interview.interviewservice.repository.specification.InterviewSpecification;
import com.flatirons.interview.interviewservice.service.InterviewService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class InterviewServiceImpl implements InterviewService {

    private final InterviewRepository interviewRepository;
    private final FeedbackRepository feedbackRepository;
    private final InterviewMapper interviewMapper;
    private final FeedbackMapper feedbackMapper;
    private final CandidateClient candidateClient;
    private final InterviewerClient interviewerClient;
    private final NotificationClient notificationClient;

    public InterviewServiceImpl(
            InterviewRepository interviewRepository,
            FeedbackRepository feedbackRepository,
            InterviewMapper interviewMapper,
            FeedbackMapper feedbackMapper,
            CandidateClient candidateClient,
            InterviewerClient interviewerClient, NotificationClient notificationClient) {

        this.interviewRepository = interviewRepository;
        this.feedbackRepository = feedbackRepository;
        this.interviewMapper = interviewMapper;
        this.feedbackMapper = feedbackMapper;
        this.candidateClient = candidateClient;
        this.interviewerClient = interviewerClient;
        this.notificationClient = notificationClient;
    }

    @Override
    @CircuitBreaker(name = "interviewService", fallbackMethod = "scheduleFallback")
    public InterviewResponseDto scheduleInterview(InterviewRequestDto dto) {

        candidateClient.validateCandidate(dto.getCandidateId());
        interviewerClient.validateInterviewer(dto.getInterviewerId());

        Interview interview = interviewMapper.toEntity(dto);
        Interview saved = interviewRepository.save(interview);

        notificationClient.send(
                "Interview scheduled for candidate " + dto.getCandidateId()
        );

        return interviewMapper.toDto(saved);
    }

    @Override
    public void submitFeedback(Long interviewId, FeedbackRequestDto feedbackRequestDto) {

        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new RuntimeException("Interview not found"));

        Feedback feedback = feedbackMapper.toEntity(feedbackRequestDto);
        feedback.setInterviewId(interview.getId());

        feedbackRepository.save(feedback);
    }

    @Override
    public Page<InterviewResponseDto> search(Long candidateId,
                                             Long interviewerId,
                                             Pageable pageable) {

        Specification<Interview> spec =
                InterviewSpecification.hasCandidateId(candidateId)
                        .and(InterviewSpecification.hasInterviewerId(interviewerId));

        return interviewRepository.findAll(spec, pageable)
                .map(interviewMapper::toDto);
    }

    /* Circuit Breaker Fallback method */
    private InterviewResponseDto scheduleFallback(InterviewRequestDto dto, Throwable ex) {
        throw new RuntimeException("Dependent service unavailable. Try later.");
    }
}

