package com.flatirons.interview.candidateservice.controller;

import com.flatirons.interview.candidateservice.dto.CandidateRequestDto;
import com.flatirons.interview.candidateservice.dto.CandidateResponseDto;
import com.flatirons.interview.candidateservice.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService service) {
        this.candidateService = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CandidateResponseDto createCandidate(@RequestBody CandidateRequestDto candidateRequestDto) {
        return candidateService.createCandidate(candidateRequestDto);
    }

    @GetMapping("/{id}")
    public CandidateResponseDto getCandidateById(@PathVariable Long id) {
        return candidateService.getCandidateById(id);
    }

    @GetMapping
    public List<CandidateResponseDto> getAllCandidates() {
        return candidateService.getAllCandidates();
    }
}
