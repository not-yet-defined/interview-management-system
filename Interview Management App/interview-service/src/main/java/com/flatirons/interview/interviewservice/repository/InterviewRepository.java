package com.flatirons.interview.interviewservice.repository;

import com.flatirons.interview.interviewservice.domain.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InterviewRepository
        extends JpaRepository<Interview, Long>,
        JpaSpecificationExecutor<Interview> {
}