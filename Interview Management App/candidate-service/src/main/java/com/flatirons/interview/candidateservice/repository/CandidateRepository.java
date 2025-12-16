package com.flatirons.interview.candidateservice.repository;


import com.flatirons.interview.candidateservice.domain.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}