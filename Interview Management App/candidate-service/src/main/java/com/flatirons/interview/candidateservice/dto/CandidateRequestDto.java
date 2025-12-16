package com.flatirons.interview.candidateservice.dto;

import lombok.Data;

@Data
public class CandidateRequestDto {
    private String name;
    private String email;
    private Integer experienceYears;
}