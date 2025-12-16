package com.flatirons.interview.candidateservice.dto;

import lombok.Data;

@Data
public class CandidateResponseDto {
    private Long id;
    private String name;
    private String email;
    private Integer experienceYears;
}