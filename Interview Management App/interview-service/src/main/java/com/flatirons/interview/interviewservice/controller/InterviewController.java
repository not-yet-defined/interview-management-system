package com.flatirons.interview.interviewservice.controller;

import com.flatirons.interview.interviewservice.dto.FeedbackRequestDto;
import com.flatirons.interview.interviewservice.dto.InterviewRequestDto;
import com.flatirons.interview.interviewservice.dto.InterviewResponseDto;
import com.flatirons.interview.interviewservice.service.InterviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interviews")
public class InterviewController {

    private final InterviewService service;

    public InterviewController(InterviewService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InterviewResponseDto schedule(@RequestBody InterviewRequestDto dto) {
        return service.scheduleInterview(dto);
    }

    @PostMapping("/{id}/feedback")
    @ResponseStatus(HttpStatus.CREATED)
    public void submitFeedback(@PathVariable Long id,
                               @RequestBody FeedbackRequestDto feedbackRequestDto) {
        service.submitFeedback(id, feedbackRequestDto);
    }

    @GetMapping
    public Page<InterviewResponseDto> search(
            @RequestParam(required = false) Long candidateId,
            @RequestParam(required = false) Long interviewerId,
            Pageable pageable) {

        return service.search(candidateId, interviewerId, pageable);
    }
}

