package com.flatirons.interview.candidateservice.service.impl;

import com.flatirons.interview.candidateservice.domain.entity.Candidate;
import com.flatirons.interview.candidateservice.dto.CandidateRequestDto;
import com.flatirons.interview.candidateservice.dto.CandidateResponseDto;
import com.flatirons.interview.candidateservice.mapper.CandidateMapper;
import com.flatirons.interview.candidateservice.repository.CandidateRepository;
import com.flatirons.interview.candidateservice.service.CandidateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidateMapper mapper;

    public CandidateServiceImpl(CandidateRepository repository, CandidateMapper mapper) {
        this.candidateRepository = repository;
        this.mapper = mapper;
    }

    @Override
    public CandidateResponseDto createCandidate(CandidateRequestDto dto) {
        Candidate saved = candidateRepository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    @Override
    public CandidateResponseDto getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    @Override
    public List<CandidateResponseDto> getAllCandidates() {
        return candidateRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}