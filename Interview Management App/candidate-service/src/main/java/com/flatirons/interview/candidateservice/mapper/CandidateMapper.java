package com.flatirons.interview.candidateservice.mapper;

import com.flatirons.interview.candidateservice.domain.entity.Candidate;
import com.flatirons.interview.candidateservice.dto.CandidateRequestDto;
import com.flatirons.interview.candidateservice.dto.CandidateResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
    Candidate toEntity(CandidateRequestDto dto);
    CandidateResponseDto toDto(Candidate entity);
}