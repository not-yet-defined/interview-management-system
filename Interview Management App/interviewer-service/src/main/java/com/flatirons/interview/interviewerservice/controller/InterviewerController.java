package com.flatirons.interview.interviewerservice.controller;

import com.flatirons.interview.interviewerservice.dto.InterviewerRequestDto;
import com.flatirons.interview.interviewerservice.dto.InterviewerResponseDto;
import com.flatirons.interview.interviewerservice.service.InterviewerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interviewers")
public class InterviewerController {

    private final InterviewerService service;

    public InterviewerController(InterviewerService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InterviewerResponseDto createInterviewer(@RequestBody InterviewerRequestDto dto) {
        return service.createInterviewer(dto);
    }

    @GetMapping("/{id}")
    public InterviewerResponseDto getInterviewerById(@PathVariable Long id) {
        return service.getInterviewerById(id);
    }

    @GetMapping
    public List<InterviewerResponseDto> getAllInterviewers() {
        return service.getAllInterviewers();
    }
}
