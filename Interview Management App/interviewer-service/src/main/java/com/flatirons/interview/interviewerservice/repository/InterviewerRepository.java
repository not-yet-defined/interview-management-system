package com.flatirons.interview.interviewerservice.repository;

import com.flatirons.interview.interviewerservice.domain.entity.Interviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewerRepository extends JpaRepository<Interviewer, Long> {
}
