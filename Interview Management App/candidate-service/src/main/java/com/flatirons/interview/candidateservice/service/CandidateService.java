package com.flatirons.interview.candidateservice.service;

import com.flatirons.interview.candidateservice.dto.CandidateRequestDto;
import com.flatirons.interview.candidateservice.dto.CandidateResponseDto;

import java.util.List;

public interface CandidateService {

    CandidateResponseDto createCandidate(CandidateRequestDto dto);

    CandidateResponseDto getCandidateById(Long id);

    List<CandidateResponseDto> getAllCandidates();
}
